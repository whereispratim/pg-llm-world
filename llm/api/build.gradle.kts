plugins {
  java
}

java {
  sourceCompatibility = JavaVersion.VERSION_22
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(22))
  }
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}
repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
  //implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive:3.3.3")
  implementation(libs.spring.boot.mongodb.reactive)
  implementation(libs.reactor.core)
  compileOnly(libs.lombok)
  annotationProcessor(libs.lombok)
}

tasks.test {
  useJUnitPlatform()
}
