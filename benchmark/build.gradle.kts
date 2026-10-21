import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsExec

plugins {
    id("driver.kotlin-js")
    id("app.cash.sqldelight")
}

description = "Benchmark of all driver backends, not published"

kotlin {
    js {
        binaries.executable()
    }
    sourceSets {
        jsMain.dependencies {
            implementation(project(":core"))
            implementation(project(":node-sqlite"))
            implementation(project(":better-sqlite3"))
            implementation(project(":sqlite3"))
        }
    }
}

sqldelight {
    databases {
        create("BenchmarkDatabase") {
            packageName.set("cz.sazel.sqldelight.node.sqlite.benchmark.db")
            generateAsync.set(true)
            srcDirs("src/jsMain/sqldelight")
        }
    }
}

tasks.withType<NodeJsExec>().configureEach {
    val outDir = layout.buildDirectory.dir("benchmark").get().asFile
    environment("BENCH_OUT", outDir.absolutePath)
    environment("BENCH_ROWS", providers.gradleProperty("bench.rows").getOrElse("1000000"))
    providers.gradleProperty("bench.backends").orNull?.let { environment("BENCH_BACKENDS", it) }
}

// convention adds library binaries too, their distribution reads the executable's sync output, not needed here
tasks.matching { it.name.endsWith("LibraryDistribution") }.configureEach { enabled = false }
