import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinMultiplatform

plugins {
    id("org.jetbrains.dokka")
    id("com.vanniktech.maven.publish")
    signing
}

dokka {
    moduleName.set(provider { "node-sqlite-driver-${project.name}" })
}

mavenPublishing {
    configure(KotlinMultiplatform(javadocJar = JavadocJar.Dokka("dokkaGeneratePublicationHtml")))
    coordinates(artifactId = "node-sqlite-driver-${project.name}")
    publishToMavenCentral()

    val signingKey = providers.gradleProperty("signingInMemoryKey").orNull
        ?: System.getenv("GPG_KEY_SECRET") ?: localProperty("gpg.keySecret")
    if (signingKey != null) {
        signAllPublications()
        signing {
            useInMemoryPgpKeys(
                signingKey,
                providers.gradleProperty("signingInMemoryKeyPassword").orNull
                    ?: System.getenv("GPG_KEY_PASSWORD") ?: localProperty("gpg.keyPassword")
            )
        }
    }

    pom {
        name.set("node-sqlite-driver-${project.name}")
        description.set(provider { project.description })
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

publishing {
    repositories {
        val githubUser = System.getenv("GITHUB_USER") ?: localProperty("github.user")
        if (githubUser != null) {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/wojta/sqldelight-node-sqlite3-driver")
                credentials {
                    username = githubUser
                    password = System.getenv("GITHUB_TOKEN") ?: localProperty("github.token")
                }
            }
        }
    }
}
