plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
    alias(libs.plugins.moko.multiplatfrom.resources)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.moko.resources)
            api(libs.moko.resources.compose)
        }
        commonTest.dependencies {
            implementation(libs.moko.resources.test)
        }
    }
}

multiplatformResources {
    resourcesPackage = "and.degilevich.dream"
    resourcesClassName = "Res"
    iosBaseLocalizationRegion = "en"
}

android {
    namespace = "and.degilevich.dream.shared.core.resource.api"
}