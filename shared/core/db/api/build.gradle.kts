plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
    alias(libs.plugins.project.room)
}

kotlin {
    android {
        namespace = "and.degilevich.dream.shared.core.db.api"
    }
}
