plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.design.theme)
            api(libs.bundles.coil)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.design.system"
    }
}