rootProject.name = "MyApplication"

include(":app")
include(":core:ui")
include(":core:strings")
include(":common:multi-compose")
include(":common:ui-components")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}