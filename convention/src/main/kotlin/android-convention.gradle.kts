import and.degilevich.dream.convention.common.androidConfig
import and.degilevich.dream.convention.common.javaVersion
import and.degilevich.dream.convention.common.compileSdk
import and.degilevich.dream.convention.common.minSdk
import org.jetbrains.kotlin.gradle.dsl.KotlinBaseExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinBasePlugin

androidConfig {
    compileSdk = compileSdk()

    defaultConfig {
        minSdk = minSdk()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    packaging {
        resources.excludes.apply {
            add("META-INF/*.kotlin_module")
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
        }
    }
}

plugins.withType<KotlinBasePlugin> {
    configure<KotlinBaseExtension> {
        jvmToolchain(javaVersion())
    }
}