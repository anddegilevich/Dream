plugins {
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.core.service.api)
            implementation(projects.shared.foundation.abstraction)
            implementation(libs.ktor.client.mock)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.core.service.test"
    }
}
