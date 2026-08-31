plugins {
    alias(libs.plugins.project.feature.domain.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.auth.domain.api)
            implementation(projects.shared.core.storage.api)
            implementation(projects.shared.core.db.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.auth.data.test)
            implementation(projects.shared.core.storage.test)
            implementation(projects.shared.core.db.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.auth.domain.impl"
    }
}
