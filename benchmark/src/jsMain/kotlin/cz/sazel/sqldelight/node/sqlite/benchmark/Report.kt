package cz.sazel.sqldelight.node.sqlite.benchmark

import kotlin.js.json

private const val LABEL_WIDTH = 44
private const val COLUMN_WIDTH = 16
private const val WHOLE_NUMBER_FROM = 100

class Metric(val scenario: String, val name: String, val value: Double, val unit: String) {
    val label get() = "$scenario: $name [$unit]"
}

/** Metrics of one backend, printed as they come. */
class Report {
    val metrics = mutableListOf<Metric>()
    private var lastScenario: String? = null

    fun add(scenario: String, name: String, value: Double, unit: String) {
        if (scenario != lastScenario) {
            println(scenario)
            lastScenario = scenario
        }
        metrics += Metric(scenario, name, value, unit)
        println("  ${name.padEnd(LABEL_WIDTH)} ${value.format()} $unit")
    }

    fun writeJson(path: String) {
        val array = metrics.map {
            json("scenario" to it.scenario, "name" to it.name, "value" to it.value, "unit" to it.unit)
        }
        NodeFs.writeFileSync(path, JSON.stringify(array.toTypedArray()))
    }
}

fun readMetrics(path: String): List<Metric> =
    JSON.parse<Array<dynamic>>(NodeFs.readFileSync(path, "utf8")).map {
        Metric(it.scenario.unsafeCast<String>(), it.name.unsafeCast<String>(), it.value.unsafeCast<Double>(),
            it.unit.unsafeCast<String>())
    }

fun printComparison(results: Map<String, List<Metric>>) {
    val labels = results.values.flatten().map { it.label }.distinct()
    val labelWidth = labels.maxOf { it.length }
    println()
    println("".padEnd(labelWidth) + results.keys.joinToString("") { it.padStart(COLUMN_WIDTH) })
    labels.forEach { label ->
        val cells = results.values.joinToString("") { metrics ->
            (metrics.firstOrNull { it.label == label }?.value?.format() ?: "-").padStart(COLUMN_WIDTH)
        }
        println(label.padEnd(labelWidth) + cells)
    }
}

private fun Double.format(): String {
    val digits = if (this >= WHOLE_NUMBER_FROM || this == kotlin.math.floor(this)) 0 else 2
    return asDynamic().toFixed(digits).unsafeCast<String>()
}
