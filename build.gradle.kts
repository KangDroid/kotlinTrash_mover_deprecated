import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    val springBootVersion = "2.1.7.RELEASE"

    repositories {
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
        classpath("org.jetbrains.kotlin:kotlin-allopen:1.4.21")
    }
}

plugins {
    kotlin("jvm") version "1.4.21"
}

group = "me.kangdroid"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compile("org.springframework.boot:spring-boot-starter-web")
    testImplementation(kotlin("test-junit"))
    testCompile("org.assertj:assertj-core:3.11.1")
}

apply {
    plugin("kotlin-spring")
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "com.kangdroid.main.MainEntryKt"
    }

    from(sourceSets.main.get().output)
    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}