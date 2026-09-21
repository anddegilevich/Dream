plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
    alias(libs.plugins.project.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.abstraction)
            api(projects.shared.feature.base.domain.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.base.domain.impl"
    }
}
