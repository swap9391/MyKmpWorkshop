import org.gradle.kotlin.dsl.invoke
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kspCompose)
    alias(libs.plugins.kotlinCocoapods)
    id("com.google.gms.google-services")
    kotlin("plugin.serialization") version "1.9.10"
    id("org.jetbrains.kotlinx.kover") version "0.9.2"

}

kotlin {

    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "17.4"

    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.compose.ui)
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.compose.material3)
            implementation(libs.androidx.activity.compose)
            implementation(libs.androidx.compose.navigation)
            implementation("androidx.lifecycle:lifecycle-viewmodel-compose")
            implementation("androidx.navigation:navigation-compose:2.7.7")
            implementation("androidx.compose.material:material:1.6.8")

            // add the dependency for the Google AI client SDK for Android
            // Firebase BOM (always use the platform BOM for Firebase dependencies)
            implementation(project.dependencies.platform("com.google.firebase:firebase-bom:33.15.0"))
            // Firebase AI Logic (for Gemini access)
            implementation("com.google.firebase:firebase-ai")

            // Firebase App Check (REQUIRED for production with Firebase AI Logic)
            //implementation("com.google.firebase:firebase-appcheck-playintegrity") // Or another provider like firebase-appcheck-debug
            implementation(libs.firebase.appcheck.debug)


            //Lottie
            implementation("com.airbnb.android:lottie-compose:6.4.1")
            //Gson
            implementation("com.google.code.gson:gson:2.10.1")
            implementation("androidx.compose.ui:ui-tooling:1.6.8")
            implementation(libs.ktor.client.cio)
            implementation("io.insert-koin:koin-androidx-compose:3.5.3")

        }


        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.lifecycle.viewmodel)
            //implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.9.4")
            implementation(libs.navigation.compose)
            implementation(libs.androidx.constraintlayout.compose)

            implementation("org.jetbrains.androidx.navigation:navigation-compose:2.8.0-alpha02")

            //Ktor
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)

            // Koin Core for KMP
            implementation(libs.koin.core)
            implementation(libs.lifecycle.viewmodel.compose)
            implementation(libs.koin.compose) // or latest

        }

        val commonTest by getting {
            dependencies {
                implementation(libs.kotlinx.coroutines.test)
                implementation(libs.kotlin.test)
            }
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }

    }
}

android {
    namespace = "com.kocfour.mykmpworkshop"
    compileSdk = 36
    defaultConfig {
        applicationId = "com.kocfour.mykmpworkshop"
        minSdk = 31
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

kover {
    reports {
        filters {
            includes {
                classes("com.kocfour.mykmpworkshop.usermanagement.presentation.*")
                classes("com.kocfour.mykmpworkshop.usermanagement.domain.*")
            }
        }
    }
}

tasks.register("coverageReport") {
    dependsOn("koverHtmlReport")
}

dependencies {
    implementation(libs.androidx.ui.graphics.android)
    debugImplementation(libs.compose.ui.tooling)
}
