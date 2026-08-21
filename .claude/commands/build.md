Build the app for the given platform: `$ARGUMENTS` (`android` or `ios`).

If `$ARGUMENTS` is `android`, run:

```bash
./gradlew :android:app:assembleDebug
```

If `$ARGUMENTS` is `ios`, run:

```bash
xcodebuild build -project ios/app.xcodeproj -configuration Debug -scheme prodDebug -sdk iphonesimulator
```

If no platform is given, ask which one to build.
