// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.agp.lib) apply false
    alias(libs.plugins.agp.app) apply false
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    /* remove that because is the only for kotlin 2.0 + alias(libs.plugins.compose.compiler) apply false */
    alias(libs.plugins.about.libraries.plugin) apply false
}