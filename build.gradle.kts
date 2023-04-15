import org.jetbrains.kotlin.gradle.targets.js.yarn.yarn
import java.util.*

plugins {
    kotlin("multiplatform") version "1.8.20"
    //id("dev.petuska.npm.publish") version "2.1.1"
    id("org.jetbrains.dokka") version "1.8.10"
    id("org.jetbrains.kotlinx.kover") version "0.6.1"
    id("maven-publish")
    id("signing")
}

group = "cz.sazel.sqldelight"
val versionBase = "0.1.0"
val localProperties = Properties().apply {
    try {
        load(project.rootProject.file("local.properties").inputStream())
    } catch (e: java.io.IOException) {
        println("Can't read local.properties, skipping")
    }
}

version = System.getenv("PACKAGE_VERSION") ?: localProperties["packageVersion"] as String? ?: "$versionBase-SNAPSHOT"


repositories {
    mavenCentral()
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/wojta/sqldelight-node-sqlite3-driver") // Github Package
        credentials {
            //Fetch these details from the properties file or from Environment variables
            username = localProperties["github.user"] as String? ?: System.getenv("GITHUB_USER")
            password = localProperties["github.token"] as String? ?: System.getenv("GITHUB_TOKEN")
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
            kover {
                htmlReport {
                    onCheck.set(true)
                }
                isDisabled.set(false)
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
                maven {
                    name = "GitHubPackages"
                    url = uri("https://maven.pkg.github.com/wojta/sqldelight-node-sqlite3-driver") // Github Package

                    credentials {
                        //Fetch these details from the properties file or from Environment variables
                        username = localProperties["github.user"] as String? ?: System.getenv("GITHUB_USER")
                        password = localProperties["github.token"] as String? ?: System.getenv("GITHUB_TOKEN")
                    }
                }
                maven {
                    val isSnapshot = version.toString().endsWith("SNAPSHOT")
                    val destination = if (isSnapshot) {
                        "https://oss.sonatype.org/service/local/staging/deploy/maven2/"
                    } else "https://oss.sonatype.org/content/repositories/snapshots/"
                    url = uri(destination)
                    credentials {
                        username = localProperties["sonatype.user"] as String? ?: System.getenv("SONATYPE_USER")
                        password = localProperties["sonatype.password"] as String? ?: System.getenv("SONATYPE_PASSWORD")
                    }
                }
            }
        }
        //val publishing = extensions.getByType<PublishingExtension>()
        extensions.configure<SigningExtension> {
            useInMemoryPgpKeys(
                localProperties["gpg.keySecret"] as String? ?: System.getenv("GPG_KEY_SECRET"),
                localProperties["gpg.keyPassword"] as String? ?: System.getenv("GPG_KEY_PASSWORD")
            )

            sign(publishing.publications)
        }
    }



    plugins.withType<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin> {
        configure<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension> {
            nodeVersion = "18.14.2"
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
    doLast {
        val sqlite3moduleDir = buildDir.resolve("js/node_modules/sqlite3")
        if (!sqlite3moduleDir.resolve("lib/binding").exists()) {
            exec {
                workingDir = sqlite3moduleDir
                val commandLine = yarn.yarnSetupTaskProvider.get().destination.absolutePath + "/bin/yarn"
                commandLine(commandLine)
            }
        }
    }
}.get()
tasks["kotlinNpmInstall"].finalizedBy(bindingsInstall)

koverMerged {
    htmlReport {
        onCheck.set(true)
    }
    enable()
}
