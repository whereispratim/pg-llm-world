pluginManagement {
  includeBuild("gradle/build-logic")
  repositories {
    gradlePluginPortal()
    mavenCentral()
  }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "pg-llm-world"
include("llm:api")
include("llm:ollama-provider")
include("llm:hf-provider")
include("llm:realtime-data-provider")