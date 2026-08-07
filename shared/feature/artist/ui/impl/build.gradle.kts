plugins {
    alias(libs.plugins.project.feature.ui.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.ui.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.artist.domain.model.core.test)
            implementation(projects.shared.feature.image.domain.model.artifact.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.artist.ui.impl"
    }
}