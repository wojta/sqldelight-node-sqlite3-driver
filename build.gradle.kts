import java.util.*

plugins {
    kotlin("multiplatform") version "1.6.20"
    id("dev.petuska.npm.publish") version "2.1.1"
    id("maven-publish")
}

group = "cz.sazel.sqldelight"
val versionBase = "0.0.1"
val localProperties = Properties().apply {
    try {
        load(project.rootProject.file("local.properties").inputStream())
    } catch (e: java.io.IOException) {
        println("Can't read local.properties, skipping")
    }
}

version = System.getenv("PACKAGE_VERSION") ?: localProperties["packageVersion"] as String? ?: "$versionBase-snapshot"


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
    jcenter()
}
enum class Platforms {
    JVM, JS

}

val platforms = listOf(Platforms.JVM, Platforms.JS)


kotlin {


    if (Platforms.JVM in platforms) {
        jvm {
            compilations.all {
                kotlinOptions.jvmTarget = "1.8"
            }
            withJava()
            testRuns["test"].executionTask.configure {
                useJUnitPlatform()
            }
        }
    }
    if (Platforms.JS in platforms) {
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

            binaries.library()
        }
    }


    sourceSets {
        val coroutinesVersion = "1.6.0"

        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")
            }
        }
        if (Platforms.JVM in platforms) {
            val jvmMain by getting {
                dependencies {
                    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:$coroutinesVersion")
                }
            }
            val jvmTest by getting

        }
        if (Platforms.JS in platforms) {
            val jsMain by getting {
                dependencies {
                    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:$coroutinesVersion")
                    implementation("org.jetbrains.kotlinx:kotlinx-nodejs:0.0.7")
//              implementation(npm("@types/node", "16.11.7", generateExternals = true)) // in future when it would work
                }
            }

            val jsTest by getting
        }

        val publicationsFromMainHost =
            listOf(jvm(), js()).map { it.name } + "kotlinMultiplatform"


        publishing {
            publications {
                matching { it.name in publicationsFromMainHost }.all {
                    val targetPublication = this@all
                    tasks.withType<AbstractPublishToMaven>()
                        .matching { it.publication == targetPublication }
                        .configureEach { onlyIf { findProperty("isMainHost") == "true" } }
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
            }
        }
    }



    npmPublishing {
        organization = "wojta"
        access = RESTRICTED


        repositories {
            repository("npmjs") {
                registry = uri("https://npm.pkg.github.com") // Registry to publish to
                authToken = localProperties["github.token"] as String?
                    ?: System.getenv("GITHUB_TOKEN")// NPM registry authentication token
            }
        }
    }
}
