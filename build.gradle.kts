plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader

    // Jetbrains
    alias(libs.plugins.jetbrains.compose.plugin) apply false
    alias(libs.plugins.jetbrains.kotlin.multiplatform.plugin) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm.plugin) apply false
    alias(libs.plugins.jetbrains.kotlin.native.cocoapods.plugin) apply false

    // Android
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.android.library.plugin) apply false
}