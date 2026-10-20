pluginManagement {
    includeBuild("build-logic")
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

rootProject.name = "sqldelight-node-sqlite-driver"

include(":core", ":sqlite3", ":node-sqlite", ":better-sqlite3", ":driver-test")
