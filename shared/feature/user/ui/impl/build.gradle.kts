plugins {
    alias(libs.plugins.project.feature.ui.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.user.ui.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.user.domain.model.core.test)
            implementation(projects.shared.feature.image.domain.model.artifact.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.user.ui.impl"
    }
}
