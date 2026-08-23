plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
    alias(libs.plugins.project.di)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.core.deeplink.api)
            implementation(projects.shared.core.webauth.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.core.deeplink.impl"
    }
}
