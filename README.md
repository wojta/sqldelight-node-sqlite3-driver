![BUILD](https://github.com/wojta/sqldelight-node-sqlite3-driver/actions/workflows/build.yml/badge.svg) [![stability-beta](https://img.shields.io/badge/stability-beta-33bbff.svg)](https://github.com/mkenney/software-guides/blob/master/STABILITY-BADGES.md#beta)
[![Maven Central](https://img.shields.io/maven-central/v/cloud.nst/worker?color=blue)](https://central.sonatype.com/artifact/cloud.nst/worker)

# sqldelight-node-sqlite-driver

Driver for the library [SQLDelight](https://github.com/cashapp/sqldelight) that runs on Node.js with one of three
SQLite modules:

| Backend                                                          | Artifact                                | Node.js | Native build                |
|------------------------------------------------------------------|-----------------------------------------|---------|-----------------------------|
| [`node:sqlite`](https://nodejs.org/api/sqlite.html)              | `node-sqlite-driver-node-sqlite-js`     | 24+     | no, built into Node.js      |
| [`better-sqlite3`](https://www.npmjs.com/package/better-sqlite3) | `node-sqlite-driver-better-sqlite3-js`  | 22+     | no, prebuilt binary in package |
| [`sqlite3`](https://www.npmjs.com/package/sqlite3)               | `node-sqlite-driver-sqlite3-js`         | 20+     | yes, install script         |

All of them share `node-sqlite-driver-core-js` with the driver itself (`SQLiteDriver`), so you always add core
and one backend.

`node:sqlite` is the easiest choice, no npm package and no install script. `sqlite3` still depends on deprecated
`prebuild-install`, which prints a warning on every clean install.

* example here: https://github.com/wojta/example-sqldelight-node-sqlite3-driver

## [API KDoc](https://wojta.github.io/sqldelight-node-sqlite3-driver/)

## Gradle set up

Pretty much it's almost the same as with https://sqldelight.github.io/sqldelight/2.4.0/js_sqlite

Initialization of SQLDelight is needed

```kotlin
plugins {
    kotlin("multiplatform") version "2.4.20" // probably would work even with different one
    id("app.cash.sqldelight") version "2.4.1"
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

Add dependency to core and to one backend:

```kotlin
kotlin {
    js {
        binaries.executable()
        nodejs()
    }
    sourceSets {
        jsMain.dependencies {
            implementation("cz.sazel.sqldelight:node-sqlite-driver-core-js:1.1.0")
            implementation("cz.sazel.sqldelight:node-sqlite-driver-node-sqlite-js:1.1.0")
            // or node-sqlite-driver-better-sqlite3-js / node-sqlite-driver-sqlite3-js
        }
    }
}
```

### Install scripts for `sqlite3`

Kotlin's Yarn skips npm install scripts by default, so `sqlite3` would miss its native binding. Turn them on
in the root project:

```kotlin
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootEnvSpec

plugins.withType<YarnPlugin> {
    the<YarnRootEnvSpec>().ignoreScripts.set(false)
}
```

`node:sqlite` and `better-sqlite3` don't need this.

## Simple example

Queries are written as here - https://sqldelight.github.io/sqldelight/2.4.0/js_sqlite/#using-queries

```kotlin
import cz.sazel.sqldelight.node.sqlite.initNodeSqliteSqlDriver

suspend fun main() {
    val driver = initNodeSqliteSqlDriver(filename = "test.db", schema = Database.Schema)

    val database = Database(driver)

    val playerQueries: PlayerQueries = database.playerQueries

    println(playerQueries.selectAll().awaitAsList())
    // Prints [HockeyPlayer(15, "Ryan Getzlaf")]

    playerQueries.insert(player_number = 10, full_name = "Corey Perry")
    println(playerQueries.selectAll().awaitAsList())
    // Prints [HockeyPlayer(15, "Ryan Getzlaf"), HockeyPlayer(10, "Corey Perry")]

    val player = HockeyPlayer(20, "Ronald McDonald")
    playerQueries.insertFullPlayerObject(player)

    driver.close()
}
```

Init function per backend:

| Backend          | Function                                                                     |
|------------------|------------------------------------------------------------------------------|
| `node:sqlite`    | `cz.sazel.sqldelight.node.sqlite.initNodeSqliteSqlDriver`                     |
| `better-sqlite3` | `cz.sazel.sqldelight.node.sqlite.betterSqlite3.initBetterSqlite3SqlDriver`    |
| `sqlite3`        | `cz.sazel.sqldelight.node.sqlite3.initSqlite3SqlDriver`                       |

Note: Please use `awaitAsList()` or `executeAsFlow()` in queries instead of `executeAsList()`
as that API is not suspending and will throw an exception with this driver.

The API is asynchronous for all backends. `sqlite3` runs queries on libuv threads by itself, `node:sqlite` and
`better-sqlite3` run them in a worker thread. That one has some build requirements and option for parallel reads,
see [Worker threads](docs/worker-threads.md).

## Upgrade from 0.9.x

Artifacts and some package names changed in 1.0.0, steps are in [Upgrade from 0.9.x to 1.0.0](docs/upgrade-1.0.md).

## Limitations

* `Long` (SQLite `INTEGER`) columns round-trip exactly only up to `2^53` (JS's safe integer
  range), because binding and reading a value both pass through a JS `Number`. Binding or reading
  a value beyond `2^53` throws `SQLiteException` instead of silently losing precision. Same for all backends.

## Transactions

By default a transaction starts with `BEGIN TRANSACTION` (deferred locking). Pass
`beginImmediate = true` to init function to start with `BEGIN IMMEDIATE` instead,
which acquires the write lock up front instead of failing with `SQLITE_BUSY` when the transaction
later upgrades from a read lock:

```kotlin
val driver = initNodeSqliteSqlDriver(filename = "test.db", schema = Database.Schema, beginImmediate = true)
```

## AI disclaimer
AI/LLM assistance is used in every step of the development process.

## Thanks

To _Isuru Rajapakse_ and the project [KStore](https://github.com/xxfast/KStore) which is an inspiration for the set-up
of publishing in Gradle scripts.

To authors of SQLDelight, implementation is based on the [sqljs](https://github.com/sql-js/sql.js/) implementation of
the driver which is already included in the library.s.

## License

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific
language governing permissions and limitations under the License.
