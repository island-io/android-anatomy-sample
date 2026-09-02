# Anatomy Sample App

A minimal Gradle Android project for the Island blog post *Android Anatomy 101:
Deconstructing the Bundle*. It builds the ordinary way, so the APK you take apart is
exactly what your own build produces.

One screen, one label: `screen_title` = **"Overview"**.

## Prerequisites

- **A JDK, 17 or newer.** Verified on 17, 21 and 23. Any build works: `brew install openjdk@21`,
  a Temurin release, or the JBR that ships inside Android Studio.
- **The Android SDK**, with platform `android-34` and build-tools `34.0.0` (the version AGP 8.6.1
  resolves to). An existing Android Studio install already has both, so there is nothing to do.
  Only if you are starting without one do you need the standalone command-line tools:
  ```bash
  sdkmanager "platforms;android-34" "build-tools;34.0.0"
  ```
- **`$ANDROID_HOME` exported, and the SDK tools on your `PATH`.** Gradle on its own is happy with
  a `local.properties` containing `sdk.dir=<path>`, but the walkthrough drives `aapt2`, `zipalign`,
  `apksigner` and `adb` directly, and those ship inside the SDK rather than on your `PATH`:
  ```bash
  export ANDROID_HOME=$HOME/Library/Android/sdk   # wherever your SDK lives
  export PATH="$ANDROID_HOME/build-tools/34.0.0:$ANDROID_HOME/platform-tools:$PATH"
  ```

Android Studio is not required. If Gradle picks a JDK you don't want, point it somewhere else:

```bash
export JAVA_HOME=/opt/homebrew/opt/openjdk@21
```

## Build

```bash
./gradlew assembleDebug     # -> app/build/outputs/apk/debug/app-debug.apk
```

The debug APK is signed with the standard debug keystore, which Gradle creates at
`~/.android/debug.keystore` on the first debug build. `./gradlew assembleRelease` gives you an
unsigned release APK, and `./gradlew bundleRelease` an AAB.
