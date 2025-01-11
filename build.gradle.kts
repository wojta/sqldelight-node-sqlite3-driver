@file:OptIn(ExperimentalKotlinGradlePluginApi::class)

import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsPlugin.Companion.kotlinNodeJsEnvSpec
import org.jetbrains.kotlin.gradle.targets.js.yarn.yarn
import java.util.*

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.detekt)
    alias(libs.plugins.dokka)
    alias(libs.plugins.kover)
    id("maven-publish")
    id("signing")
}

val defaultGroupId = "cz.sazel.sqldelight"
val versionBase = "0.4.0"

val localProperties = Properties().apply {
    try {
        load(project.rootProject.file("local.properties").inputStream())
    } catch (e: java.io.IOException) {
        System.err.println("Can't read local.properties, skipping")
    }
}

group = System.getenv("GROUP_ID") ?: localProperties["groupId"] as String? ?: defaultGroupId
var versionStr = System.getenv("PACKAGE_VERSION")?.trim()?.ifBlank { null }
    ?: localProperties["packageVersion"] as String? ?: "$versionBase-SNAPSHOT"
if (versionStr.startsWith("v")) versionStr = versionStr.substring(1)
version = versionStr

println("Package version $version")

repositories {
    mavenCentral()
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/wojta/sqldelight-node-sqlite3-driver") // Github Package
        credentials {
            //Fetch these details from the properties file or from Environment variables
            username = System.getenv("GITHUB_USER") ?: localProperties["github.user"] as String?
            password = System.getenv("GITHUB_TOKEN") ?: localProperties["github.token"] as String?
        }
    }
}

kotlin {

    js(IR) {
        compilations.all {
            kotlinOptions.moduleKind = "commonjs"
        }

        useCommonJs()
        nodejs {
            version = libs.versions.node.js.get()
            testTask {
                // debug=true
            }
        }
        generateTypeScriptDefinitions()
        binaries.library()
    }


    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation(libs.kotlin.coroutines.core)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.kotlin.coroutines.test)
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(libs.sqldelight.runtime.js)
                implementation(libs.sqldelight.async.extensions.js)
                implementation(npm("sqlite3", libs.versions.node.sqlite3.get(), false))
            }
        }
        val jsTest by getting {

        }

        val publicationsFromMainHost =
            listOf(js()).map { it.name } + "kotlinMultiplatform"

        dokka {
            moduleName = "node-sqlite3-driver"
            moduleVersion = versionStr

            dokkaSourceSets {
                val jsMain by getting {

                }
            }
        }

        publishing {

            publications {
                matching { it.name in publicationsFromMainHost }.all {
                    val targetPublication = this@all
                    tasks.withType<AbstractPublishToMaven>()
                        .matching { it.publication == targetPublication }
                        .configureEach { onlyIf { findProperty("isMainHost") == "true" } }
                }


                withType<MavenPublication> {
                    artifact(layout.buildDirectory.dir("dokka"))

                    pom {
                        name.set("node-sqlite3-driver")
                        description.set("Driver for the library SQLDelight that supports sqlite3 Node.js module")
                        licenses {
                            license {
                                name.set("Apache-2.0")
                                url.set("https://opensource.org/licenses/Apache-2.0")
                            }
                        }
                        url.set("https://github.com/wojta/sqldelight-node-sqlite3-driver")
                        issueManagement {
                            system.set("Github")
                            url.set("https://github.com/wojta/sqldelight-node-sqlite3-driver/issues")
                        }
                        scm {
                            connection.set("https://github.com/wojta/sqldelight-node-sqlite3-driver.git")
                            url.set("https://github.com/wojta/sqldelight-node-sqlite3-driver")
                        }
                        developers {
                            developer {
                                name.set("Vojtěch Sázel")
                                email.set("sqldelight@sazel.cz")
                            }
                        }
                    }
                }

            }

            repositories {
                val githubUserName = System.getenv("GITHUB_USER") ?: localProperties["github.user"] as String?
                if (githubUserName != null) { // Github packages repo
                    maven {
                        name = "GitHubPackages"
                        url = uri("https://maven.pkg.github.com/wojta/sqldelight-node-sqlite3-driver") // Github Package

                        credentials {
                            //Fetch these details from the properties file or from Environment variables
                            username = githubUserName
                            password = System.getenv("GITHUB_TOKEN") ?: localProperties["github.token"] as String?
                        }
                    }
                }
                maven { // OSS Sonatype (default)
                    val isSnapshot = version.toString().endsWith("SNAPSHOT")
                    val destination = if (!isSnapshot) {
                        "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
                    } else "https://s01.oss.sonatype.org/content/repositories/snapshots"
                    url = uri(destination)
                    credentials {
                        username = System.getenv("SONATYPE_USER") ?: localProperties["sonatype.user"] as String?
                        password = System.getenv("SONATYPE_PASSWORD") ?: localProperties["sonatype.password"] as String?
                    }
                }
            }
        }

        signing {
            useInMemoryPgpKeys(
                System.getenv("GPG_KEY_SECRET") ?: localProperties["gpg.keySecret"] as String?,
                System.getenv("GPG_KEY_PASSWORD") ?: localProperties["gpg.keyPassword"] as String?
            )

            sign(publishing.publications)
        }
    }
}

// workaround for missing sqlite3 bindings
val bindingsInstall = tasks.register("sqlite3BindingsInstall") {
    doFirst {

    }
    doLast {
        val sqlite3moduleDir = layout.buildDirectory.get().dir("js/node_modules/sqlite3").asFile
        if (!sqlite3moduleDir.resolve("build").exists()) {
            exec {
                workingDir = sqlite3moduleDir
                val yarnExecutable = yarn.environment.executable
                val yarnPath = file(yarnExecutable).parent
                val nodePath = file(kotlinNodeJsEnvSpec.executable).parent
                environment(
                    "PATH", System.getenv("PATH") + ":$yarnPath:$nodePath"
                )
                commandLine(yarnExecutable)
            }
        }
    }
}.get()
tasks["kotlinNpmInstall"].finalizedBy(bindingsInstall)

detekt {
    buildUponDefaultConfig = true // preconfigure defaults
    allRules = false // activate all available (even unstable) rules.
    config.setFrom("$projectDir/gradle/detekt/detekt.yml") // point to your custom config defining rules to run, overwriting default behavior
    //   baseline = file("$projectDir/config/baseline.xml") // a way of suppressing issues before introducing detekt

    reports {
        html.required.set(true) // observe findings in your browser with structure and code snippets
    }
}

