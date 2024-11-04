plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.service)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
   // id("com.google.gms.google-services")
}

android {
    namespace = "com.example.appifoodtcc"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.appifoodtcc"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.viewmodel.android)
    implementation(project(":core"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics.ktx)
    implementation(libs.firebase.auth.ktx)
    implementation(libs.firebase.firestore.ktx)
    implementation(libs.firebase.storage.ktx)

    //library hilt dagger
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    //library de mascara
    implementation(libs.maskededittext)

    //library validacao
    implementation (libs.easyvalidation.core)


    //fragment ktx
    implementation(libs.androidx.core.ktx)

    //splaScreem
    implementation(libs.androidx.core.splashscreen)

    val nav_version = "2.7.7"
    // Kotlin
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    //biblioteca picasso
    implementation("com.squareup.picasso:picasso:2.8")

    //Android Image Slider
    implementation("com.github.denzcoskun:ImageSlideshow:0.1.2")

}

kapt {
    correctErrorTypes = true
}