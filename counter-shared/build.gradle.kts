import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val versionCounter: String by rootProject.extra
val versionJdk: JavaVersion by rootProject.extra
val versionAndroidSdk: Int by rootProject.extra
val versionAndroidSdkMin: Int by rootProject.extra
val versioniOSMin: String by rootProject.extra

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
}

version = versionCounter

kotlin {
    android()
    iosX64()
    iosArm64()

    sourceSets {
        // Common
        val commonMain by getting {
            dependencies {

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        // Android
        val androidMain by getting
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation(Testing.junit4)
            }
        }

        // iOS
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
        }
    }

    cocoapods {
        summary = "Counter Shared Module"
        homepage = "https://github.com/alexandregressier/counter-decompose-kmp"
        ios.deploymentTarget = versioniOSMin
        podfile = project.file("../counter-ios-app/Podfile")
        framework {
            baseName = "CounterShared"
        }
    }
}

android {
    compileSdk = versionAndroidSdk
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        minSdk = versionAndroidSdkMin
        targetSdk = versionAndroidSdk
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "$versionJdk"
    }
}