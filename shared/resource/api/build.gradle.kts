plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.abstraction)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.resource.api"
    }
}

multiplatformResources {
    resourcesPackage = "and.degilevich.dream"
    resourcesClassName = "Res"
    iosBaseLocalizationRegion = "en"
}