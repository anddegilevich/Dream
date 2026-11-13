plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
    alias(libs.plugins.project.di)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.resource.api)
            implementation(projects.shared.core.network.api)
            implementation(projects.shared.core.service.api)
            api(projects.shared.core.toast.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.resource.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.core.toast.impl"
    }
}