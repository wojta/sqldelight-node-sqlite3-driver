@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS",
    "TooManyFunctions", "MatchingDeclarationName", "MaxLineLength","UnusedPrivateProperty",
    "UnusedParameter","UnusedPrivateMember"
)

package node.sqlite3


@JsModule("sqlite3")
external object Sqlite3 {

    var OPEN_READONLY: Number

    var OPEN_READWRITE: Number

    var OPEN_CREATE: Number

    var OPEN_FULLMUTEX: Number

    var OPEN_SHAREDCACHE: Number

    var OPEN_PRIVATECACHE: Number

    var OPEN_URI: Number

    var VERSION: String

    var SOURCE_ID: String

    var VERSION_NUMBER: Number

    var OK: Number

    var ERROR: Number

    var INTERNAL: Number

    var PERM: Number

    var ABORT: Number

    var BUSY: Number

    var LOCKED: Number

    var NOMEM: Number

    var READONLY: Number

    var INTERRUPT: Number

    var IOERR: Number

    var CORRUPT: Number

    var NOTFOUND: Number

    var FULL: Number

    var CANTOPEN: Number

    var PROTOCOL: Number

    var EMPTY: Number

    var SCHEMA: Number

    var TOOBIG: Number

    var CONSTRAINT: Number

    var MISMATCH: Number

    var MISUSE: Number

    var NOLFS: Number

    var AUTH: Number

    var FORMAT: Number

    var RANGE: Number

    var NOTADB: Number

    var LIMIT_LENGTH: Number

    var LIMIT_SQL_LENGTH: Number

    var LIMIT_COLUMN: Number

    var LIMIT_EXPR_DEPTH: Number

    var LIMIT_COMPOUND_SELECT: Number

    var LIMIT_VDBE_OP: Number

    var LIMIT_FUNCTION_ARG: Number

    var LIMIT_ATTACHED: Number

    var LIMIT_LIKE_PATTERN_LENGTH: Number

    var LIMIT_VARIABLE_NUMBER: Number

    var LIMIT_TRIGGER_DEPTH: Number

    var LIMIT_WORKER_THREADS: Number

    internal object cached {
        fun Database(filename: String, callback: (self: Database, err: Error?) -> Unit = definedExternally): Database
        fun Database(filename: String, mode: Number = definedExternally, callback: (self: Database, err: Error?) -> Unit = definedExternally): Database
    }

    internal interface RunResult : Statement {
        var lastID: Number
        var changes: Number
    }

    internal open class Statement : node.events.EventEmitter {
        open fun bind(params: Array<Any?>, callback: (self: Any?) -> Unit = definedExternally): Statement /* this */

        //        open fun bind(callback: (err: Error?) -> Unit = definedExternally): Statement /* this */
//        open fun bind(): Statement /* this */
//        open fun bind(vararg params: Any): Statement /* this */
        open fun reset(callback: (err: Nothing?) -> Unit = definedExternally): Statement /* this */
        open fun finalize(callback: (err: Error) -> Unit = definedExternally): Database
        open fun run(callback: (err: Error?) -> Unit = definedExternally): Statement /* this */
        open fun run(): Statement /* this */

        //open fun run(params: Any, callback: (self: RunResult, err: Error?) -> Unit = definedExternally): Statement /* this */
        open fun run(params: Any, callback: (self: Any?) -> Unit): Statement
        open fun run(params: Any): Statement /* this */
        open fun get(callback: (err: Error?, row: Any) -> Unit = definedExternally): Statement /* this */
        open fun get(): Statement /* this */
        open fun get(params: Any, callback: (self: RunResult, err: Error?, row: Any) -> Unit = definedExternally): Statement /* this */
        open fun get(params: Any): Statement /* this */

        open fun all(callback: (err: Error?, rows: Array<Array<dynamic>>) -> Unit = definedExternally): Statement /* this */
//        open fun all(callback: (rows: Any) -> Unit): Statement /* this */

        //open fun all(): Statement /* this */
//        open fun all(params: Any, callback: (self: RunResult, err: Error?, rows: Array<Any>) -> Unit = definedExternally): Statement /* this */
//        open fun all(params: Any): Statement /* this */
        open fun each(callback: (err: Error?, row: Any) -> Unit = definedExternally, complete: (err: Error?, count: Number) -> Unit = definedExternally): Statement /* this */
        open fun each(): Statement /* this */
        open fun each(callback: (err: Error?, row: Any) -> Unit = definedExternally): Statement /* this */
        open fun each(
            params: Any,
            callback: (self: RunResult, err: Error?, row: Any) -> Unit = definedExternally,
            complete: (err: Error?, count: Number) -> Unit = definedExternally
        ): Statement /* this */

        open fun each(params: Any): Statement /* this */
        open fun each(params: Any, callback: (self: RunResult, err: Error?, row: Any) -> Unit = definedExternally): Statement /* this */
    }

    internal open class Database : node.events.EventEmitter {
        constructor(filename: String, callback: (err: Error?) -> Unit = definedExternally)
        constructor(filename: String)
        constructor(filename: String, mode: Number = definedExternally, callback: (err: Error?) -> Unit = definedExternally)
        constructor(filename: String, mode: Number = definedExternally)

        open fun close(callback: (err: Error?) -> Unit = definedExternally)
        open fun run(sql: String, callback: (self: Any?) -> Unit = definedExternally): Database /* this */

        open fun run(sql: String): Database
        open fun run(sql: String, params: Any?, callback: (self: Any?) -> Unit = definedExternally): Database /* this */

        //        open fun run(sql: String, params: Any): Database /* this */
        open fun get(sql: String, callback: (self: Statement, err: Error?, row: Any) -> Unit = definedExternally): Database /* this */
        open fun get(sql: String): Database /* this */
        open fun get(sql: String, params: Any, callback: (self: Statement, err: Error?, row: Any) -> Unit = definedExternally): Database /* this */
        open fun get(sql: String, params: Any): Database /* this */
        open fun all(sql: String, callback: (self: Statement, err: Error?, rows: Array<Any>) -> Unit = definedExternally): Database /* this */
        open fun all(sql: String): Database /* this */
        open fun all(sql: String, params: Any, callback: (self: Statement, err: Error?, rows: Array<Any>) -> Unit = definedExternally): Database /* this */
        open fun all(sql: String, params: Any): Database /* this */
        open fun each(
            sql: String,
            callback: (self: Statement, err: Error?, row: Any) -> Unit = definedExternally,
            complete: (err: Error?, count: Number) -> Unit = definedExternally
        ): Database /* this */

        open fun each(sql: String): Database /* this */
        open fun each(sql: String, callback: (self: Statement, err: Error?, row: Any) -> Unit = definedExternally): Database /* this */
        open fun each(
            sql: String,
            params: Any,
            callback: (self: Statement, err: Error?, row: Any) -> Unit = definedExternally,
            complete: (err: Error?, count: Number) -> Unit = definedExternally
        ): Database /* this */

        open fun each(sql: String, params: Any): Database /* this */
        open fun each(sql: String, params: Any, callback: (self: Statement, err: Error?, row: Any) -> Unit = definedExternally): Database /* this */
        open fun exec(sql: String, callback: (self: Any?) -> Unit = definedExternally): Database /* this */

        //open fun prepare(sql: String, callback: (self: Statement, err: Error?) -> Unit = definedExternally): Statement
        open fun prepare(sql: String, callback: (self: Any) -> Unit): Statement

        open fun prepare(sql: String): Statement
        open fun prepare(sql: String, params: Any?, callback: (self: Any) -> Unit): Statement

        //open fun prepare(sql: String, params: Any): Statement
        open fun serialize(callback: () -> Unit = definedExternally)
        open fun parallelize(callback: () -> Unit = definedExternally)
        open fun on(event: String /* "trace" */, listener: (sql: String) -> Unit): Database /* this */
        open fun on(event: String /* "profile" */, listener: (sql: String, time: Number) -> Unit): Database /* this */
        open fun on(event: String /* "change" */, listener: (type: String, database: String, table: String, rowid: Number) -> Unit): Database /* this */
        open fun on(event: String /* "error" */, listener: (err: Error) -> Unit): Database /* this */
        open fun on(event: String /* "open" | "close" */, listener: () -> Unit): Database /* this */
        override fun on(eventName: String, listener: (args: Any) -> Unit): Database /* this */
        open fun configure(option: String /* "busyTimeout" */, value: Number)
        open fun configure(option: String /* "limit" */, id: Number, value: Number)
        open fun loadExtension(filename: String, callback: (err: Error?) -> Unit = definedExternally): Database /* this */
        open fun wait(callback: (param: Nothing?) -> Unit = definedExternally): Database /* this */
        open fun interrupt()
    }

// fun verbose(): sqlite3
}
