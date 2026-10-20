plugins {
    id("driver.kotlin-js")
    id("driver.publish")
}

description = "SQLDelight driver backend for the node:sqlite module built into Node.js"

kotlin {
    sourceSets {
        jsMain.dependencies {
            implementation(project(":core"))
        }
        jsTest.dependencies {
            implementation(project(":driver-test"))
        }
    }
}
