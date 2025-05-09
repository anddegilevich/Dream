plugins {
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.compose.multiplatform) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.test) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.kotlinx.serialization) apply false
    alias(libs.plugins.moko.multiplatfrom.resources) apply false
    alias(libs.plugins.buildkonfig) apply false
    alias(libs.plugins.baselineprofile) apply false
    alias(libs.plugins.ktor) apply false
}

buildscript {
    dependencies {
        classpath(libs.moko.resources.generator.gradle)
    }
}