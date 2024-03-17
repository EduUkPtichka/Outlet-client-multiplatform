rootProject.name = "Outlet-client-multiplatform"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

//plugins {
//    alias(libs.plugins.jetbrains.kotlin.jvm.plugin)
//    alias(libs.plugins.gmazzo.buildconfig.plugin)
//}
//
//buildConfig {
//    buildConfigField("APP_NAME", "Outlet-client-multiplatform")
//    buildConfigField("module_build_support_buildkonfig", "build-support-buildсonfig")
//}



includeBuild("build-support-buildconfig")


include(":composeApp")