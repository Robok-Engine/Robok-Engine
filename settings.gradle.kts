pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

rootProject.name = "Robok-IDE"

include(":app")

include(":robok:robok-compiler")
include(":robok:robok-diagnostic")
include(":robok:robok-lang")
include(":robok:robok-util")

include(":feature:feature-base")
include(":feature:feature-component")
include(":feature:feature-manage")
include(":feature:feature-model")
include(":feature:feature-setting")
include(":feature:feature-res:res")
include(":feature:feature-res:strings")
include(":feature:feature-util")