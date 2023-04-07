import java.util.*

plugins {
    kotlin("multiplatform") version "1.8.20"
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
        val jsTest by getting

        val publicationsFromMainHost =
            listOf(js()).map { it.name } + "kotlinMultiplatform"


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

    plugins.withType<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin> {
        configure<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension> {
            nodeVersion = "18.14.2"
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
