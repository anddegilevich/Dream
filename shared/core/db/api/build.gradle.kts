plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.ksp)
    alias(libs.plugins.project.serialization)
    alias(libs.plugins.project.coroutines)
}

kotlin {
    sourceSets {
        androidMain.dependencies { }
        commonMain.dependencies {
            api(libs.room.runtime)
            api(libs.room.ktx)
            api(libs.room.paging)
        }
        commonTest.dependencies {
            api(libs.room.testing)
        }
    }
}

dependencies {
    add("kspAndroid", libs.room.compiler)
    add("kspIosSimulatorArm64", libs.room.compiler)
    add("kspIosX64", libs.room.compiler)
    add("kspIosArm64", libs.room.compiler)
}

android {
    namespace = "and.degilevich.dream.shared.core.db.api"
}
