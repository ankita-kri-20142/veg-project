//buildscript {
//    dependencies {
//        classpath("com.android.tools.build:gradle:8.1.0")
//        classpath("com.google.gms:google-services:4.4.3")
//        // Other classpaths if needed
//    }
//}
plugins {
    id("com.android.application") version "8.11.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.21" apply false
    id("org.jetbrains.compose") version "1.5.0" apply false
    id("com.google.gms.google-services") version "4.4.3" apply false
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
