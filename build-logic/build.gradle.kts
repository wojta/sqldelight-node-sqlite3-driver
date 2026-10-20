plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.gradle.plugin.detekt)
    implementation(libs.gradle.plugin.dokka)
    implementation(libs.gradle.plugin.kotlin)
    implementation(libs.gradle.plugin.kover)
    implementation(libs.gradle.plugin.maven.publish)
    implementation(libs.gradle.plugin.owasp.dependencycheck)
    implementation(libs.gradle.plugin.sqldelight)
}

// kotlin-dsl compiles with Gradle's embedded Kotlin, older than the plugins' metadata
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions.freeCompilerArgs.add("-Xskip-metadata-version-check")
}
