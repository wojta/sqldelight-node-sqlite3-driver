package cz.sazel.sqldelight.node.sqlite

import cloud.nst.worker.JobTicket
import cloud.nst.worker.Task
import cloud.nst.worker.ThreadPool
import cloud.nst.worker.Transferred
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.serialization.builtins.serializer
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

private const val OPEN_REQUEST_ID = 0
private const val ROW_BATCH = 256

/**
 * Opens a connection in its own worker thread. The thread imports [registrarModule], which registers
 * a [SQLiteConnectionTask] as [taskName]. Requests and rows go over a `MessagePort` by structured clone.
 */
@InternalSQLiteDriverApi
suspend fun openWorkerConnection(taskName: String, registrarModule: String, filename: String): SQLiteConnection {
    val scope = CoroutineScope(SupervisorJob())
    val pool = ThreadPool(count = 1, coroutineScope = scope, registrarModules = listOf(registrarModule))
    pool.start()
    val channel: dynamic = js("new MessageChannel()")
    val connection = WorkerSQLiteConnection(channel.port1, pool, scope)
    try {
        val ticket = pool.transfer(
            taskName, filename, String.serializer(), Unit.serializer(), channel.port2.unsafeCast<Any>(), thread = 0,
        )
        connection.awaitOpen(ticket)
    } catch (@Suppress("TooGenericExceptionCaught") e: Throwable) {
        connection.shutdown()
        throw e as? SQLiteException ?: SQLiteJsException(e)
    }
    return connection
}

/**
 * Worker side of [openWorkerConnection]: opens the connection with [open] and serves requests
 * of the main thread until it closes the connection.
 */
@InternalSQLiteDriverApi
class SQLiteConnectionTask(private val open: (filename: String) -> SQLiteConnection) :
    Task<String, Unit>(String.serializer(), Unit.serializer()) {

    override suspend fun invoke(input: String) {
        val port: dynamic = checkNotNull(currentCoroutineContext()[Transferred]) { "No port transferred" }.value
        val requests = Channel<dynamic>(Channel.UNLIMITED)
        port.on("message") { request: dynamic -> requests.trySend(request) }

        val server = try {
            ConnectionServer(wrapJsErrors { open(input) })
        } catch (@Suppress("TooGenericExceptionCaught") e: Throwable) {
            port.postMessage(errorReply(OPEN_REQUEST_ID, e))
            return
        }
        port.postMessage(reply(OPEN_REQUEST_ID, null))

        for (request in requests) {
            val id = request.id.unsafeCast<Int>()
            val op = request.op.unsafeCast<String>()
            try {
                port.postMessage(reply(id, server.handle(op, request)))
                if (op == "close") break
            } catch (@Suppress("TooGenericExceptionCaught") e: Throwable) {
                port.postMessage(errorReply(id, e))
            }
        }
    }

    private fun reply(id: Int, value: Any?): dynamic {
        val reply: dynamic = js("({})")
        reply.id = id
        reply.value = value
        return reply
    }

    private fun errorReply(id: Int, e: Throwable): dynamic {
        val error: dynamic = js("({})")
        error.message = e.message
        // the original JS error doesn't survive the thread boundary with its SQLite code
        error.errno = (e as? SQLiteJsException)?.errorNumber ?: -1
        val reply: dynamic = js("({})")
        reply.id = id
        reply.error = error
        return reply
    }
}

private class ConnectionServer(private val connection: SQLiteConnection) {
    private val statements = mutableMapOf<Int, SQLiteStatement>()
    private var nextStatementId = 0

    suspend fun handle(op: String, request: dynamic): Any? = when (op) {
        "prepare" -> nextStatementId++.also { statements[it] = connection.prepare(request.sql.unsafeCast<String>()) }
        "exec" -> connection.exec(request.sql.unsafeCast<String>()).let { null }
        "close" -> connection.close().let { null }
        else -> handleStatement(op, request.stmt.unsafeCast<Int>(), request)
    }

    private suspend fun handleStatement(op: String, id: Int, request: dynamic): Any? {
        val statement = statements[id] ?: throw SQLiteException("Unknown statement $id")
        return when (op) {
            "bind" -> statement.bind(request.params.unsafeCast<Array<Any?>>().toList()).let { null }
            "run" -> statement.run().toDouble()
            "step" -> stepBatch(statement)
            "reset" -> statement.reset().let { null }
            "finalize" -> statement.finalize().also { statements.remove(id) }.let { null }
            else -> throw SQLiteException("Unknown request $op")
        }
    }

    private suspend fun stepBatch(statement: SQLiteStatement): dynamic {
        val rows = mutableListOf<Array<dynamic>>()
        var done = false
        while (rows.size < ROW_BATCH) {
            val row = statement.step()
            if (row == null) {
                done = true
                break
            }
            rows.add(row)
        }
        val batch: dynamic = js("({})")
        batch.rows = rows.toTypedArray()
        batch.done = done
        return batch
    }
}

private class WorkerSQLiteConnection(
    private val port: dynamic,
    private val pool: ThreadPool,
    private val scope: CoroutineScope,
) : SQLiteConnection {
    private val pending = mutableMapOf<Int, CancellableContinuation<dynamic>>()
    private var nextRequestId = OPEN_REQUEST_ID + 1
    private lateinit var ticket: JobTicket<Unit>

    init {
        port.on("message") { reply: dynamic ->
            val continuation = pending.remove(reply.id.unsafeCast<Int>())
            val error = reply.error
            when {
                continuation == null -> Unit
                error == null -> continuation.resume(reply.value)
                else -> continuation.resumeWithException(SQLiteJsException(remoteError(error)))
            }
        }
    }

    suspend fun awaitOpen(ticket: JobTicket<Unit>) {
        this.ticket = ticket
        scope.launch {
            try {
                ticket.await()
            } catch (@Suppress("TooGenericExceptionCaught") e: Throwable) {
                // the worker thread died, nothing pending gets a reply anymore
                val waiting = pending.values.toList()
                pending.clear()
                waiting.forEach { it.resumeWithException(SQLiteJsException(e)) }
            }
        }
        suspendCancellableCoroutine<dynamic> { pending[OPEN_REQUEST_ID] = it }
    }

    suspend fun request(op: String, fill: (dynamic) -> Unit = {}): dynamic = suspendCancellableCoroutine { cont ->
        val id = nextRequestId++
        val request: dynamic = js("({})")
        request.id = id
        request.op = op
        fill(request)
        pending[id] = cont
        cont.invokeOnCancellation { pending.remove(id) }
        try {
            port.postMessage(request)
        } catch (@Suppress("TooGenericExceptionCaught") e: Throwable) {
            pending.remove(id)
            cont.resumeWithException(SQLiteJsException(e))
        }
    }

    override suspend fun prepare(sql: String): SQLiteStatement =
        WorkerSQLiteStatement(this, request("prepare") { it.sql = sql }.unsafeCast<Int>())

    override suspend fun exec(sql: String) {
        request("exec") { it.sql = sql }
    }

    override suspend fun close() {
        request("close")
        ticket.await()
        shutdown()
    }

    fun shutdown() {
        pool.shutdown()
        port.close()
        scope.cancel()
    }

    @Suppress("UnusedParameter")
    private fun remoteError(error: dynamic): Throwable =
        js("Object.assign(new Error(error.message), { errno: error.errno })").unsafeCast<Throwable>()
}

/**
 * Rows are fetched from the worker in batches of [ROW_BATCH].
 */
@OptIn(InternalSQLiteDriverApi::class)
private class WorkerSQLiteStatement(private val connection: WorkerSQLiteConnection, private val id: Int) :
    SQLiteStatement {
    private var rows: Array<dynamic>? = null
    private var position = 0
    private var done = false

    override suspend fun bind(parameters: List<Any?>) {
        clearRows()
        // a Kotlin Long doesn't survive structured clone
        val params = parameters.withLongsAsBigInt()
        request("bind") { it.params = params }
    }

    override suspend fun run(): Long {
        clearRows()
        return request("run").unsafeCast<Double>().toLong()
    }

    override suspend fun step(): Array<dynamic>? {
        if (!hasBufferedRow() && !done) {
            val batch = request("step")
            rows = batch.rows.unsafeCast<Array<dynamic>>()
            position = 0
            done = batch.done.unsafeCast<Boolean>()
        }
        return if (hasBufferedRow()) rows!![position++] else null
    }

    override suspend fun reset() {
        clearRows()
        request("reset")
    }

    override suspend fun finalize() {
        clearRows()
        request("finalize")
    }

    private fun hasBufferedRow() = rows?.let { position < it.size } ?: false

    private fun clearRows() {
        rows = null
        position = 0
        done = false
    }

    private suspend fun request(op: String, fill: (dynamic) -> Unit = {}): dynamic =
        connection.request(op) {
            it.stmt = id
            fill(it)
        }
}
