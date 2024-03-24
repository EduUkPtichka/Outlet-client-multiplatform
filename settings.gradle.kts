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

// Application Android
include(":app-android-compose-view")

// Presentation
include(":common-presentation-feature:home-jetbrains-compose")
include(":common-presentation-feature:home-divkit-view")
include(":common-presentation-feature:auth-jetbrains-compose")

// Domain
include(":common-domain-feature:auth-mvi-decompose")
include(":common-domain-feature:home-mvi-decompose")

// Data
include(":common-data-remote-feature:home-data-remote")
include(":common-data-local-feature:home-data-local")

// Presentation Util
include(":common-presentation-util")

// Resources
include(":common-resources")

// Pojo/Poko
include("pojo-poko")

// Test Application
include(":composeApp")
