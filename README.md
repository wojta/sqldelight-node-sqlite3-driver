![BUILD](https://github.com/wojta/sqldelight-node-sqlite3-driver/actions/workflows/build.yml/badge.svg) [![stability-experimental](https://img.shields.io/badge/stability-experimental-orange.svg)](https://github.com/mkenney/software-guides/blob/master/STABILITY-BADGES.md#experimental)
[![Maven Central](https://img.shields.io/maven-central/v/cz.sazel.sqldelight/node-sqlite3-driver-js?color=blue)](https://search.maven.org/search?q=g:cz.sazel.sqldelight)


# sqldelight-node-sqlite3-driver 
Driver for the library [SQLDelight](https://github.com/cashapp/sqldelight) that supports [sqlite3](https://www.npmjs.com/package/sqlite3) Node.js module
* example here: https://github.com/wojta/example-sqldelight-node-sqlite3-driver

## [API KDoc](https://wojta.github.io/sqldelight-node-sqlite3-driver/)

## Gradle set up 

Pretty much it's almost the same as with https://cashapp.github.io/sqldelight/2.0.0-alpha05/js_sqlite/

Initialization of SQLDelight is needed

```kotlin
plugins {
    kotlin("js") version "1.8.0" // probably would work even with different one
    id("app.cash.sqldelight") version "2.0.0-alpha05" // for version 0.1.x
}
፧
፧
፧
sqldelight {
    databases {
        create("Database") {
            packageName.set("com.example")
            generateAsync.set(true) // required for this driver!
        }
    }
}
```

Add dependency to the driver:

```kotlin
kotlin {
    js {
        binaries.executable()
        nodejs {
            dependencies {
                implementation("cz.sazel.sqldelight:node-sqlite3-driver-js:0.1.5")
            }
        }
    }
}
```

You'll also need to install binary bindings for SQLite3. This can be done by adding a special Gradle task that runs yarn
in the `sqlite3` node package directory.

```kotlin
val bindingsInstall = tasks.register("sqlite3BindingsInstall") {
    doLast {
        val sqlite3moduleDir = rootProject.buildDir.resolve("js/node_modules/sqlite3")
        if (!sqlite3moduleDir.resolve("lib/binding").exists()) {
            exec {
                workingDir = sqlite3moduleDir
                val commandLine = "${yarn.yarnSetupTaskProvider.get().destination.absolutePath}/bin/yarn"
                commandLine(commandLine)
            }
        }
    }
}.get()
tasks["kotlinNpmInstall"].finalizedBy(bindingsInstall)
```

## Simple example



Queries are written as here - https://cashapp.github.io/sqldelight/2.0.0-alpha05/js_sqlite/


```kotlin
suspend fun main() {
    val driver = initSqlite3SqlDriver(filename = "test.db", schema = Database.Schema)

    val database = Database(driver)

    val playerQueries: PlayerQueries = database.playerQueries

    println(playerQueries.selectAll().executeSuspendingAsList())
    // Prints [HockeyPlayer(15, "Ryan Getzlaf")]

    playerQueries.insert(player_number = 10, full_name = "Corey Perry")
    println(playerQueries.selectAll().executeSuspendingAsList())
    // Prints [HockeyPlayer(15, "Ryan Getzlaf"), HockeyPlayer(10, "Corey Perry")]

    val player = HockeyPlayer(20, "Ronald McDonald")
    playerQueries.insertFullPlayerObject(player)
}
```

Note: Please use `executeSuspendingAsList()` in queries instead of `executeAsList()` as that API is not suspending and will throw an exception with this driver.


## Thanks
To _Isuru Rajapakse_ and the project [KStore](https://github.com/xxfast/KStore) which is an inspiration for the set-up of publishing in Gradle scripts. 

To authors of SQLDelight, implementation is based on the [sqljs](https://github.com/sql-js/sql.js/) implementation of the driver which is already included in the library.s.

## License
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
