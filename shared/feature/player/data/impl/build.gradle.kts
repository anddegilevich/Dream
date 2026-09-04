plugins {
    alias(libs.plugins.project.feature.data.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.player.data.api)
            implementation(projects.shared.feature.player.data.mapper.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.player.data.mapper.test)
            implementation(projects.shared.feature.player.domain.model.core.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.player.data.impl"
    }
}
