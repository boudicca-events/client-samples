plugins {
    kotlin("jvm") version "1.9.21"
}

group = "events.boudicca.samples"
version = "0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("events.boudicca:publisher-client:0.5.0")
    implementation("events.boudicca:ingest-client:0.5.0")
    implementation("events.boudicca:search-client:0.5.0")
    implementation("events.boudicca:enricher-client:0.5.0")
}

kotlin {
    jvmToolchain(21)
}