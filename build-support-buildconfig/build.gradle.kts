plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm.plugin)
    alias(libs.plugins.gmazzo.buildconfig.plugin)
}

buildConfig {
    useKotlinOutput {
        internalVisibility = true
        topLevelConstants = true
    }
    packageName("com.ukenov.outlet.buildsupport")

    buildConfigField("APP_NAME", "Outlet-client-multiplatform")
    buildConfigField("module_build_support_buildconfig", "build-support-buildсonfig")
    buildConfigField("module_common_presentation_compose", "common-presentation-compose")
}