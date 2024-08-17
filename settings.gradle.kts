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
include(":robok:robok-aapt2")

include(":feature:feature-component")
include(":feature:feature-setting")
include(":feature:feature-res:strings")
include(":feature:feature-util")
include(":feature:feature-template")
include(":feature:feature-terminal")
include(":feature:feature-treeview")
include(":feature:feature-theme")