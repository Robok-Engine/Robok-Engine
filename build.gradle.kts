plugins {
  id("build-logic.root-project")
  alias(libs.plugins.agp.lib) apply false
  alias(libs.plugins.agp.app) apply false
  alias(libs.plugins.kotlin) apply false
  alias(libs.plugins.kotlin.jvm) apply false
  alias(libs.plugins.kotlin.serialization) apply false
  alias(libs.plugins.compose.compiler) apply false
  alias(libs.plugins.about.libraries.plugin) apply false
}