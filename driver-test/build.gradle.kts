plugins {
    id("driver.kotlin-js")
    id("app.cash.sqldelight")
}

description = "Test suite shared by all driver backends, not published"

kotlin {
    sourceSets {
        jsMain.dependencies {
            api(project(":core"))
            api(kotlin("test"))
            api(libs.kotlin.coroutines.test)
            api(libs.sqldelight.async.extensions.js)
        }
    }
}

sqldelight {
    databases {
        create("TestDatabaseDontUse") {
            packageName.set("cz.sazel.sqldelight._dont_use")
            generateAsync.set(true)
            srcDirs("src/jsMain/sqldelight")
        }
    }
}
