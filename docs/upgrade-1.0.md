# Upgrade from 0.9.x to 1.0.0

Up to 0.9.x the driver was single artifact `node-sqlite3-driver-js` for `sqlite3` only. In 1.0.0 it is split into
core and three backends, so the old artifact gets no more releases.

## Keep `sqlite3`

1. Replace the dependency:

   ```kotlin
   // before
   implementation("cz.sazel.sqldelight:node-sqlite3-driver-js:0.9.0")

   // after
   implementation("cz.sazel.sqldelight:node-sqlite-driver-core-js:1.0.0")
   implementation("cz.sazel.sqldelight:node-sqlite-driver-sqlite3-js:1.0.0")
   ```

   Core has to be added explicitly, backend doesn't bring it to your compile classpath.

2. Fix imports. These moved from `cz.sazel.sqldelight.node.sqlite3` to `cz.sazel.sqldelight.node.sqlite` and
   dropped `3` from the name:

   | Before                                                  | After                                                 |
   |---------------------------------------------------------|-------------------------------------------------------|
   | `cz.sazel.sqldelight.node.sqlite3.SQLite3Driver`        | `cz.sazel.sqldelight.node.sqlite.SQLiteDriver`        |
   | `cz.sazel.sqldelight.node.sqlite3.SQLite3Exception`     | `cz.sazel.sqldelight.node.sqlite.SQLiteException`     |
   | `cz.sazel.sqldelight.node.sqlite3.SQLite3JsException`   | `cz.sazel.sqldelight.node.sqlite.SQLiteJsException`   |
   | `cz.sazel.sqldelight.node.sqlite3.executeAsFlow`        | `cz.sazel.sqldelight.node.sqlite.executeAsFlow`       |

   `initSqlite3SqlDriver` stays in `cz.sazel.sqldelight.node.sqlite3` with the same parameters.

3. Replace `sqlite3BindingsInstall` task with `ignoreScripts` setting from
   [Install scripts for `sqlite3`](../README.md#install-scripts-for-sqlite3). The task still works if you keep it.

## Switch to `node:sqlite` or `better-sqlite3`

Same steps 1 and 2, only with `node-sqlite-driver-node-sqlite-js` or `node-sqlite-driver-better-sqlite3-js`, and:

* call `initNodeSqliteSqlDriver` / `initBetterSqlite3SqlDriver` instead of `initSqlite3SqlDriver`, there is no
  `mode` parameter, file is always opened for read and write and created when missing
* drop `sqlite3BindingsInstall` task and `ignoreScripts` setting, none of them is needed
* `node:sqlite` needs Node.js 24 or newer, check `nodejs` version in your Gradle set up
* existing database files work as they are, all three backends use same SQLite file format
* see [worker thread requirements](worker-threads.md#requirements)

## Other changes

* `SQLiteJsException.errorNumber` is still SQLite primary result code, now for all backends
* `close()` logs failures to `console.error` as `SQLiteJsException`, not as raw JS error
* when `BEGIN` fails (e.g. `SQLITE_BUSY`), the driver no longer stays in a broken transaction, next call can
  start new one
* test database classes from package `cz.sazel.sqldelight._dont_use` aren't shipped in the library anymore
