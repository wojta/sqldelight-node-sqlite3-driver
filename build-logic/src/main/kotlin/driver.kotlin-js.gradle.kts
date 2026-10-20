import io.gitlab.arturbosch.detekt.Detekt
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsPlugin.Companion.kotlinNodeJsEnvSpec

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("io.gitlab.arturbosch.detekt")
    id("org.jetbrains.kotlinx.kover")
}

val libs = the<VersionCatalogsExtension>().named("libs")
fun library(alias: String) = libs.findLibrary(alias).get()

kotlin {
    js {
        useEsModules()
        nodejs {
            kotlinNodeJsEnvSpec.version.set(libs.findVersion("node-js").get().requiredVersion)
            testTask {
                // mocha's 2 s default is too short for file-backed tests while other tasks load the disk
                useMocha { timeout = "10s" }
            }
        }
        generateTypeScriptDefinitions()
        binaries.library()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(library("kotlin-coroutines-core"))
        }
        commonTest.dependencies {
            implementation(kotlin("test"))
            implementation(library("kotlin-coroutines-test"))
        }
        jsMain.dependencies {
            implementation(library("sqldelight-runtime-js"))
            implementation(library("sqldelight-async-extensions-js"))
        }
    }
}

detekt {
    buildUponDefaultConfig = true
    allRules = false
    config.setFrom(rootProject.file("gradle/detekt/detekt.yml"))
    // default source dirs are JVM-only, KMP source sets have to be added explicitly, generated code is skipped
    source.setFrom(kotlin.sourceSets.flatMap { it.kotlin.srcDirs }.filter { it.startsWith(file("src")) })
}

tasks.withType<Detekt>().configureEach {
    reports {
        html.required.set(true)
    }
}
