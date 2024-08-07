import io.gitlab.arturbosch.detekt.Detekt
import kotlinx.kover.gradle.plugin.dsl.KoverReportExtension
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin.Companion.kotlinNodeJsExtension
import org.jetbrains.kotlin.gradle.targets.js.yarn.yarn
import java.util.*

plugins {
    val kotlinVersion = "2.0.20-Beta1"
    kotlin("multiplatform") version kotlinVersion
    //id("dev.petuska.npm.publish") version "2.1.1"
    id("io.gitlab.arturbosch.detekt").version("1.23.0-RC2")
    id("org.jetbrains.dokka") version "1.9.0"
    id("org.jetbrains.kotlinx.kover") version "0.7.3"
    id("maven-publish")
    id("signing")
}

val defaultGroupId = "cz.sazel.sqldelight"
val versionBase = "0.3.0"

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
            extensions.configure<KoverReportExtension> {
                defaults {
                    html {
                        onCheck = true
                    }
                }
            }
        }

        val publicationsFromMainHost =
            listOf(js()).map { it.name } + "kotlinMultiplatform"

        val javadocJar = tasks.register<Jar>("javadocJar") {
            dependsOn(tasks.dokkaHtml)
            archiveClassifier.set("javadoc")
            from("$buildDir/dokka")
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
                    artifact(javadocJar)

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

        extensions.configure<SigningExtension> {
            useInMemoryPgpKeys(
                System.getenv("GPG_KEY_SECRET") ?: localProperties["gpg.keySecret"] as String?,
                System.getenv("GPG_KEY_PASSWORD") ?: localProperties["gpg.keyPassword"] as String?
            )

            sign(publishing.publications)
        }
    }



    plugins.withType<NodeJsRootPlugin> {
        configure<NodeJsRootExtension> {
            version = "18.14.2"
        }
    }

//    npmPublishing {
//        organization = "wojta"
//        access = RESTRICTED
//
//        repositories {
//            repository("npmjs") {
//                registry = uri("https://npm.pkg.github.com") // Registry to publish to
//                authToken = localProperties["github.token"] as String?
//                    ?: System.getenv("GITHUB_TOKEN")// NPM registry authentication token
//            }
//        }
//    }

}

// workaround for missing sqlite3 bindings
val bindingsInstall = tasks.register("sqlite3BindingsInstall") {
    doFirst {

    }
    doLast {
        val sqlite3moduleDir = buildDir.resolve("js/node_modules/sqlite3")
        if (!sqlite3moduleDir.resolve("lib/binding").exists()) {
            exec {
                workingDir = sqlite3moduleDir
                val yarnPath="${yarn.yarnSetupTaskProvider.get().destination.absolutePath}/bin"
                val nodePath="${kotlinNodeJsExtension.nodeJsSetupTaskProvider.get().destination.absolutePath}/bin"
                environment(
                    "PATH",
                    System.getenv("PATH") + ":$yarnPath:$nodePath"
                )
                var commandLine = "$yarnPath/yarn"
                commandLine(commandLine)
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
}

tasks.withType<Detekt>().configureEach {
    reports {
        html.required.set(true) // observe findings in your browser with structure and code snippets
    }
}
