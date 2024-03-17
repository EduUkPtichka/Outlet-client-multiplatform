plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm.plugin)
    alias(libs.plugins.gmazzo.buildconfig.plugin)
}

buildConfig {
    buildConfigField("APP_NAME", "Outlet-client-multiplatform")
    buildConfigField("module_build_support_buildkonfig", "build-support-buildсonfig")
}