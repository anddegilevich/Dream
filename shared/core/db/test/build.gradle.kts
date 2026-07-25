plugins {
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.core.db.api)
            implementation(projects.shared.foundation.abstraction)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.core.db.test"
    }
}
