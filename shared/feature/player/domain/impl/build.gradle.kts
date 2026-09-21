plugins {
    alias(libs.plugins.project.feature.domain.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.player.domain.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.player.data.test)
            implementation(projects.shared.feature.player.domain.model.core.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.player.domain.impl"
    }
}
