import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType

plugins {
    alias(libs.plugins.jetbrains.kotlin.multiplatform.plugin)
    alias(libs.plugins.jetbrains.compose.plugin)
    alias(libs.plugins.jetbrains.kotlin.native.cocoapods.plugin)
    alias(libs.plugins.android.library.plugin)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        version = "2.0"
        name = "common-presentation-util"
        summary = "For reused components"

        ios.deploymentTarget = "15.0"

        podfile = project.file("../ios-app/Podfile")

        listOf("dev", "stage", "prod").forEach { schemeName ->
            xcodeConfigurationToNativeBuildType["$schemeName-debug"] = NativeBuildType.DEBUG
            xcodeConfigurationToNativeBuildType["$schemeName-release"] = NativeBuildType.RELEASE
        }

        framework {
            baseName = "common-presentation-util"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {

            // Kotlin
            implementation(libs.jetbrains.kotlinx.collections.immutable)

            // Jetbrains Compose
            implementation(libs.jetbrains.compose.runtime)
            implementation(libs.jetbrains.compose.foundation)
            implementation(libs.jetbrains.compose.material3)
            implementation(libs.jetbrains.compose.ui)
            implementation(libs.jetbrains.compose.components.ui.toooling.preview)

            // Coil
            implementation(libs.coilkt.coil.compose)
            implementation(libs.coilkt.coil3.compose.core)

        }
        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)
        }
        iosMain.dependencies {

        }
    }
}

android {
    namespace = "com.ukenov_outlet.common_presentation_util"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    // Указывает на местоположение AndroidManifest
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.android.compileOptions.kotlinCompiler.get()
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    dependencies {
        debugImplementation(libs.androidx.compose.ui.tooling)
    }
}