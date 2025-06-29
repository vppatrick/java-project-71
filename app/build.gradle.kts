import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    application
    jacoco
    id("checkstyle")
    id("com.github.ben-manes.versions") version "0.52.0"
    id("org.sonarqube") version "6.2.0.5505"
    id("io.freefair.lombok") version "8.14"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.13.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("info.picocli:picocli:4.7.7")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.19.0")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = setOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        showStandardStreams = true
    }
}

tasks.jacocoTestReport { reports { xml.required.set(true) } }

application {
    mainClass = "hexlet.code.App"
}

sonar {
    properties {
        property("sonar.projectKey", "vppatrick_java-project-71")
        property("sonar.organization", "vppatrick")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}