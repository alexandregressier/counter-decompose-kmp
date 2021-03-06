import de.fayard.refreshVersions.core.versionFor

val versionCounter: String by rootProject.extra
val versionCodeCounter: Int by rootProject.extra
val versionJdk: JavaVersion by rootProject.extra
val versionAndroidSdk: Int by rootProject.extra
val versionAndroidSdkMin: Int by rootProject.extra

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = versionAndroidSdk

    defaultConfig {
        applicationId = "dev.gressier.counter.android"
        minSdk = versionAndroidSdkMin
        targetSdk = versionAndroidSdk
        versionCode = versionCodeCounter
        versionName = versionCounter
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = versionJdk
        targetCompatibility = sourceCompatibility
    }
    kotlinOptions {
        jvmTarget = "${compileOptions.sourceCompatibility}"
        freeCompilerArgs = freeCompilerArgs + listOf(
            "-Xopt-in=${
                listOf(
                    "com.arkivanov.decompose.ExperimentalDecomposeApi",
                ).joinToString(",")
            }"
        )
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = versionFor(AndroidX.compose.ui)
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":counter-shared"))

    // Core
    implementation(AndroidX.core.ktx)

    // Compose
    implementation(AndroidX.compose.ui)
    implementation(AndroidX.compose.ui.toolingPreview)

    // Material
    implementation(AndroidX.compose.material)

    // Lifecycle
    implementation(AndroidX.lifecycle.runtimeKtx)

    // Activity
    implementation(AndroidX.activity.compose)

    // Decompose
    implementation("com.arkivanov.decompose:extensions-compose-jetpack:_")
}