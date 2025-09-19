plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.minutebazar"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.minutebazar"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        vectorDrawables {
//            useSupportLibrary = true
//        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false // Set to true for release builds to shrink and obfuscate
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    composeOptions {
        // This version should align with your Kotlin version.
        // For Kotlin 1.9.21, the compatible Compose Compiler is 1.5.7
        // Refer to: https://developer.android.com/jetpack/androidx/releases/compose-kotlin
        kotlinCompilerExtensionVersion = "1.5.7"
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }


    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.0")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    val composeBomVersion = "2024.02.01" // Example: Check for the latest
    implementation(platform("androidx.compose:compose-bom:$composeBomVersion"))


    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.21")
    implementation("androidx.navigation:navigation-compose:2.7.0")
<<<<<<< HEAD
    implementation("androidx.compose.material:material-icons-extended:1.4.0")
// or matching your Compose version
=======


>>>>>>> 1583caf9661a19b020642e518f4d310d0451d0c6
}
