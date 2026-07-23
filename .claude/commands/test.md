Run tests for the project. Parse `$ARGUMENTS` to pick the right invocation below; if empty, run the "All tests" command.

Notes for Gradle 9 / this project's module layout:
* Android `:android:app` uses flavors (`mock`/`prod`) × build types (`debug`/`release`/...) → variant unit test tasks are `test<Flavor><BuildType>UnitTest`.
* `shared/*` KMP modules use the unified Android target, so their JVM-side unit tests run under `testAndroidHostTest` (not the old `testDebugUnitTest`), and iOS-side tests run under `iosSimulatorArm64Test`.
* Instrumented (on-device/emulator) tests only exist for `:android:app` — KMP shared modules don't have `connectedAndroidTest`.

## All tests (every module, every target)

```bash
./gradlew test
```

## Unit tests only

```bash
# Everything (app + shared modules)
./gradlew test

# Just the Android app, all variants
./gradlew :android:app:test

# Just the Android app, one flavor/buildType
./gradlew :android:app:testMockDebugUnitTest
./gradlew :android:app:testProdDebugUnitTest

# Just one shared module (JVM/Android host side)
./gradlew :shared:feature:artist:domain:impl:testAndroidHostTest

# One shared module, all its targets (e.g. host + iOS simulator)
./gradlew :shared:feature:artist:domain:impl:allTests
```

## Instrumented tests (Android, connected device/emulator)

```bash
# All variants
./gradlew :android:app:connectedAndroidTest

# One flavor/buildType
./gradlew :android:app:connectedMockDebugAndroidTest
./gradlew :android:app:connectedProdDebugAndroidTest
```

## iOS simulator tests (KMP shared module)

```bash
./gradlew :shared:feature:artist:domain:impl:iosSimulatorArm64Test
```

## Specific module, any target

```bash
./gradlew :<module:path>:test        # umbrella task for that module
./gradlew :<module:path>:allTests    # KMP modules: aggregates all targets' tests
```
