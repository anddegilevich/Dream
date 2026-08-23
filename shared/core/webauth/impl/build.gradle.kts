plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
    alias(libs.plugins.project.di)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.core.webauth.api)
            implementation(projects.shared.config)
        }
        androidMain.dependencies {
            implementation(libs.androidx.browser)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.core.webauth.impl"
    }
}
