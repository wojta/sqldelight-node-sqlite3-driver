plugins {
    id("driver.aggregate")
}

val defaultGroupId = "cz.sazel.sqldelight"
val versionBase = "1.1.0"

val packageVersion = (System.getenv("PACKAGE_VERSION")?.trim()?.ifBlank { null }
    ?: localProperty("packageVersion") ?: "$versionBase-SNAPSHOT").removePrefix("v")

allprojects {
    group = System.getenv("GROUP_ID") ?: localProperty("groupId") ?: defaultGroupId
    version = packageVersion
}

println("Package version $packageVersion")

val publishedModules = listOf(":core", ":sqlite3", ":node-sqlite", ":better-sqlite3")

dependencies {
    publishedModules.forEach { dokka(project(it)) }
    (publishedModules - ":core").forEach { kover(project(it)) }
}

dokka {
    moduleName.set("sqldelight-node-sqlite-driver")
    moduleVersion.set(packageVersion)
}

dependencyCheck {
    failBuildOnCVSS = 7.0f // fail on high/critical CVEs, don't block on low/medium noise
    formats = listOf("HTML", "JSON") // JSON used to build the PR comment summary
    suppressionFile = "$projectDir/gradle/dependency-check/suppression.xml"
    scanSet.setFrom(file("$projectDir/kotlin-js-store/yarn.lock")) // npm dependencies lockfile
    // only the shipped js target's classpath, not detekt/dokka's own bundled tool jars
    scanConfigurations = listOf("jsCompileClasspath", "jsRuntimeClasspath")
    skipProjects = listOf(":driver-test", ":benchmark")
    nvd {
        apiKey = System.getenv("NVD_API_KEY") ?: localProperty("nvd.apiKey")
    }
    analyzers {
        ossIndex {
            enabled = true
            password = System.getenv("OSS_INDEX_TOKEN") ?: localProperty("ossIndex.token")
            url = "https://api.guide.sonatype.com" // legacy ossindex.sonatype.org is being retired for Sonatype Guide
        }
    }
}
