plugins {
    id("driver.kotlin-js")
    id("driver.publish")
}

description = "SQLDelight driver backend for the sqlite3 Node.js module"

kotlin {
    sourceSets {
        jsMain.dependencies {
            implementation(project(":core"))
            implementation(npm("sqlite3", libs.versions.node.sqlite3.get()))
        }
        jsTest.dependencies {
            implementation(project(":driver-test"))
        }
    }
}
