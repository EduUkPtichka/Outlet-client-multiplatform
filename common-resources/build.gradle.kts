import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType

plugins {
    alias(libs.plugins.jetbrains.kotlin.multiplatform.plugin)
    alias(libs.plugins.jetbrains.kotlin.native.cocoapods.plugin)
    alias(libs.plugins.android.library.plugin)
    alias(libs.plugins.icerock.multiplatform.resources.plugin)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    applyDefaultHierarchyTemplate()

    cocoapods {
        version = "2.0"
        name = "common-resources"
        summary = "Multiplatform resources Android and iOS"

        ios.deploymentTarget = "15.0"

        podfile = project.file("../ios-app/Podfile")

        listOf("dev", "stage", "prod").forEach { schemeName ->
            xcodeConfigurationToNativeBuildType["$schemeName-debug"] = NativeBuildType.DEBUG
            xcodeConfigurationToNativeBuildType["$schemeName-release"] = NativeBuildType.RELEASE
        }

        framework {
            baseName = "common-resources"
            isStatic = true

            export(libs.icerock.moko.resources)
        }
    }

    sourceSets {
        commonMain.dependencies {
            api(libs.icerock.moko.resources)
        }
        androidMain.dependencies {

        }
        iosMain.dependencies {

        }
    }
}

android {
    namespace = "com.ukenov_outlet.common_resources"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    // Указывает на местоположение AndroidManifest
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

multiplatformResources {
    resourcesPackage = "com.ukenov_outlet.common_resources"
}