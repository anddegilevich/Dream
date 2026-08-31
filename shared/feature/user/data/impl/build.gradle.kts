plugins {
    alias(libs.plugins.project.feature.data.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.user.data.api)
            implementation(projects.shared.feature.user.data.mapper.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.user.data.mapper.test)
            implementation(projects.shared.feature.user.domain.model.core.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.user.data.impl"
    }
}
