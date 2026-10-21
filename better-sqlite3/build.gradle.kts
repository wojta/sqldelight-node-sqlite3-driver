plugins {
    id("driver.kotlin-js")
    id("driver.publish")
}

description = "SQLDelight driver backend for the better-sqlite3 Node.js module"

kotlin {
    sourceSets {
        jsMain.dependencies {
            implementation(project(":core"))
            implementation(libs.nst.worker)
            implementation(npm("better-sqlite3", libs.versions.node.better.sqlite3.get()))
        }
        jsTest.dependencies {
            implementation(project(":driver-test"))
        }
    }
}
