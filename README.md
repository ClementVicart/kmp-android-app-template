# Compose Multiplatform with separate Android project template

This repository aims to serve as a template for Kotlin Multiplatform projects with Compose and Android application Support.

It uses latest versions of Compose Multiplatform and Android libraries, as well as **recommended project architecture**.

> [!TIP]
> This new project architecture uses a separate Android module. This will be the default architecture in AGP 9.0.0.
> See more [here](https://kotlinlang.org/docs/multiplatform/whats-new-compose-110.html#support-for-agp-9-0-0)

## Project architecture

This project uses the latest recommended architecture for Compose Multiplaform. It is splitted in two different Gradle modules:
* **kmp**: contains the Compose Multiplatform plugin and hosts the shared source sets (JVM, Android...)
* **androidApp**: contains the Android Application plugin and common configuration you could use on pure Android project. **It depends on the `kmp` module**

The `kmp` module also uses the new `com.android.kotlin.multiplatform.library` plugin that makes a bridge
between the multiplatform source sets and the `androidApp`'s ones. This is the current recommendation from Google
and Jetbrains for new Kotlin Multiplatform projects

```
:androidApp -> Pure Android configurations and source sets
|
| Depends on
v
:kmp -> Common shared configurations and source sets
```

## How to use

Clone this repository and rename it as you want. Then, edit the following files:
* `settings.gradle.kts`
  * Change the project name in `rootProject.name`
* `kmp/build.gradle.kts`
  * Change the namespace in the `androidLibrary` block
  * Change the package of the generated resources in the `compose.resources` block
  * Change the main class of the JVM platform in the `compose.desktop` block
* `androidApp/build.gradle.kts`
  * Change the namespace
  * Change the applicationId
* `gradle/libs.versions.toml`
  * Edit the android SDK min/compile versions following your needs
