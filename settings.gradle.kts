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

// Build Support Gradle - Мои помощники по сборке проекта.
includeBuild("build-support-buildconfig")

// Presentation
include(":common-feature-presentation:jetbrains-compose:home-jetbrains-compose")

// Resources
include(":common-resources")

// Pojo/Poko
include("pojo-poko")

// Test Application
include(":composeApp")
