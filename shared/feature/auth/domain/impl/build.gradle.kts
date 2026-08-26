plugins {
    alias(libs.plugins.project.feature.domain.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.auth.domain.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.auth.data.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.auth.domain.impl"
    }
}
