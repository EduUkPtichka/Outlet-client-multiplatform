rootProject.name = "Outlet-client-multiplatform"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

// build.gradle.kts

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

includeBuild("build-support-buildconfig")

//Presentation
include(":common-feature-presentation:jetbrains-compose:home-jetbrains-compose")

include(":composeApp")

//Pojo/Poko
include("pojo-poko")
