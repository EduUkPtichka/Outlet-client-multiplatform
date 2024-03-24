Pod::Spec.new do |spec|
    spec.name                     = 'home-jetbrains-compose'
    spec.version                  = '2.0'
    spec.homepage                 = ''
    spec.source                   = { :http=> ''}
    spec.authors                  = ''
    spec.license                  = ''
    spec.summary                  = 'Feature home module. Compose multiplatform'
    spec.vendored_frameworks      = 'build/cocoapods/framework/home_jetbrains_compose.framework'
    spec.libraries                = 'c++'
    spec.ios.deployment_target = '15.0'
                
                
    if !Dir.exist?('build/cocoapods/framework/home_jetbrains_compose.framework') || Dir.empty?('build/cocoapods/framework/home_jetbrains_compose.framework')
        raise "

        Kotlin framework 'home_jetbrains_compose' doesn't exist yet, so a proper Xcode project can't be generated.
        'pod install' should be executed after running ':generateDummyFramework' Gradle task:

            ./gradlew :common-presentation-feature:home-jetbrains-compose:generateDummyFramework

        Alternatively, proper pod installation is performed during Gradle sync in the IDE (if Podfile location is set)"
    end
                
    spec.pod_target_xcconfig = {
        'KOTLIN_PROJECT_PATH' => ':common-presentation-feature:home-jetbrains-compose',
        'PRODUCT_MODULE_NAME' => 'home_jetbrains_compose',
    }
                
    spec.script_phases = [
        {
            :name => 'Build home-jetbrains-compose',
            :execution_position => :before_compile,
            :shell_path => '/bin/sh',
            :script => <<-SCRIPT
                if [ "YES" = "$OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED" ]; then
                  echo "Skipping Gradle build task invocation due to OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED environment variable set to \"YES\""
                  exit 0
                fi
                set -ev
                REPO_ROOT="$PODS_TARGET_SRCROOT"
                "$REPO_ROOT/../../gradlew" -p "$REPO_ROOT" $KOTLIN_PROJECT_PATH:syncFramework \
                    -Pkotlin.native.cocoapods.platform=$PLATFORM_NAME \
                    -Pkotlin.native.cocoapods.archs="$ARCHS" \
                    -Pkotlin.native.cocoapods.configuration="$CONFIGURATION"
            SCRIPT
        }
    ]
    spec.resources = ['build\compose\ios\home-jetbrains-compose\compose-resources']
end