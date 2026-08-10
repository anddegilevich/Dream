package and.degilevich.dream.convention.common

import org.gradle.api.Project

private const val VERIFICATION_GROUP = "verification"
private const val UNIT_TEST_TASK = "unitTest"
private const val UI_TEST_TASK = "uiTest"
private const val ANDROID_HOST_TEST_TASK = "testAndroidHostTest"
private const val IOS_SIMULATOR_TEST_TASK = "iosSimulatorArm64Test"

internal fun Project.registerUnitTestTask() {
    tasks.register(UNIT_TEST_TASK) {
        group = VERIFICATION_GROUP
        description = "Runs host-side unit tests for this module."
        dependsOn(ANDROID_HOST_TEST_TASK)
    }
}

internal fun Project.registerUITestTask() {
    tasks.register(UI_TEST_TASK) {
        group = VERIFICATION_GROUP
        description = "Runs Compose UI tests for this module."
        dependsOn(IOS_SIMULATOR_TEST_TASK)
    }
    // Compose UI tests need Robolectric to run on the Android host target,
    // so for now they only run on the iOS simulator target.
    tasks.matching { task -> task.name == ANDROID_HOST_TEST_TASK }.configureEach {
        enabled = false
    }
}
