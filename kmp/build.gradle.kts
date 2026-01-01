import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.android.multiplatform.library)
}

kotlin {

    androidLibrary {
        compileSdk = libs.versions.compileSdk.get().toInt()
        namespace = "com.example.kmp"
        compilerOptions {
            jvmTarget = JvmTarget.JVM_11 // Max supported version for Android
        }
    }

    jvm {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_25 // Current LTS
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.foundation)
            implementation(libs.compose.runtime)
            implementation(libs.compose.ui)
            implementation(libs.compose.material3)
            implementation(libs.compose.material.icons.core)
            implementation(libs.compose.material.icons.extended)
            implementation(libs.compose.navigation3.ui)
            implementation(libs.compose.components.resources)
        }

        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = "com.example.kmp"
    generateResClass = always
}

compose.desktop {
    application {
        mainClass = "comp.example.kmp.MainKt"
    }
}