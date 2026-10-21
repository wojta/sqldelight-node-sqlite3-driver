plugins {
    id("driver.kotlin-js")
    id("driver.publish")
}

description = "Backend-independent part of the SQLDelight driver for Node.js SQLite modules"

kotlin {
    sourceSets {
        jsMain.dependencies {
            implementation(libs.nst.worker)
            implementation(libs.kotlin.serialization.core)
        }
    }
}
