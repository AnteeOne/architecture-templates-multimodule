rootProject.name = "MyApplication"

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

include(":app")
include(":core:ui")
include(":core:strings")
include(":core:utils")
include(":common:domain")
include(":common:data")
include(":common:data-remote")
include(":common:data-local")
include(":common:di")
include(":common:ui")
include(":common:ui-components")
include(":common:multi-compose")
