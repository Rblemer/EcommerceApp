plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "br.com.ecommerce_app"
    compileSdk = 34

    defaultConfig {
        applicationId = "br.com.ecommerce_app"
        minSdk = 24
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.47")
    kapt("com.google.dagger:hilt-compiler:2.47")
    annotationProcessor("com.google.dagger:hilt-compiler:2.47")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    // viewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    // viewModel utilities for Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.compose.runtime:runtime-livedata:1.5.0")

    // Lifecycles only (without viewModel or LiveData)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose:compose-bom:2023.03.00")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    // Preview
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Navigation Component
    implementation("androidx.navigation:navigation-compose:2.7.0")

    implementation("com.google.gms:google-services:4.4.0")

    // Firebase
    implementation("com.google.firebase:firebase-crashlytics-gradle:2.9.9")
    implementation("com.google.firebase:firebase-messaging-ktx:23.3.1")
    implementation("com.google.firebase:firebase-bom:32.6.0")
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-crashlytics-ktx:18.6.0")
    implementation("com.google.firebase:firebase-firestore-ktx:24.9.1")
    implementation("com.google.firebase:firebase-auth-ktx:22.3.0")

    // WorkManager
    implementation("androidx.work:work-runtime-ktx:2.8.1")
    implementation("androidx.work:work-gcm:2.8.1")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    // Retrofit with Moshi Converter
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")

    // OkHttp
    implementation("com.squareup.okhttp3:okhttp:4.9.3")

    // Moshi
    implementation("com.squareup.moshi:moshi-kotlin:1.15.0")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.47")
    kapt("com.google.dagger:hilt-compiler:2.47")
    annotationProcessor("com.google.dagger:hilt-compiler:2.47")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    // Room
    implementation("androidx.room:room-runtime:2.5.2")
    implementation("androidx.room:room-ktx:2.5.2")
    annotationProcessor("androidx.room:room-compiler:2.5.2")
    kapt("androidx.room:room-compiler:2.5.2")

    // JWT
    implementation("io.github.nefilim.kjwt:kjwt-core:0.8.0")
    implementation("io.github.nefilim.kjwt:kjwt-jwks:0.8.0")
    implementation("io.arrow-kt:arrow-core:1.0.1")

    // Lottie
    implementation("com.airbnb.android:lottie-compose:6.1.0")

    //Coil
    implementation("io.coil-kt:coil-compose:2.4.0")
}
