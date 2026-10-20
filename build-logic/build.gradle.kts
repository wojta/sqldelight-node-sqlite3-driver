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
