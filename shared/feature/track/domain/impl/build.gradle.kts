plugins {
    alias(libs.plugins.project.feature.domain.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.track.domain.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.track.data.test)
            implementation(projects.shared.feature.track.domain.model.core.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.track.domain.impl"
    }
}