import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootEnvSpec

plugins {
    id("org.jetbrains.dokka")
    id("org.jetbrains.kotlinx.kover")
    id("org.owasp.dependencycheck")
}

// sqlite3 fetches its native binding in an install script, Kotlin's Yarn skips them by default
plugins.withType<YarnPlugin> {
    the<YarnRootEnvSpec>().ignoreScripts.set(false)
}
