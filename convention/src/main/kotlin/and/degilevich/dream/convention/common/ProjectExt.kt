package and.degilevich.dream.convention.common

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.the
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.androidConfig(block: AndroidExtensions.() -> Unit): Unit = block(androidExtension())

internal fun Project.libs(): LibrariesForLibs = the<LibrariesForLibs>()

internal fun Project.javaVersion(): Int = libs().versions.java.get().toInt()

internal fun Project.compileSdk(): Int = libs().versions.android.compile.sdk.get().toInt()

internal fun Project.minSdk(): Int = libs().versions.android.min.sdk.get().toInt()

internal fun Project.targetSdk(): Int = libs().versions.android.target.sdk.get().toInt()

internal fun Project.kotlinMultiplatformConfig(block: KotlinMultiplatformExtension.() -> Unit) {
    extensions.findByType<KotlinMultiplatformExtension>()
        ?.apply(block)
        ?: error("Kotlin multiplatform was not been added")
}