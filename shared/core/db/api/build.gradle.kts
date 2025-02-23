plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
    alias(libs.plugins.project.room)
}

android {
    namespace = "and.degilevich.dream.shared.core.db.api"
}
