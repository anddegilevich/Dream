plugins {
    alias(libs.plugins.project.feature.domain.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.user.domain.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.user.data.test)
            implementation(projects.shared.feature.user.domain.model.core.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.user.domain.impl"
    }
}
