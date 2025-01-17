plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // Add the Google services Gradle plugin
    id("com.google.gms.google-services")
}

android {
    namespace = "com.ericksebas03.realidadaumentadamuseo"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.ericksebas03.realidadaumentadamuseo"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    // Habilitar ViewBinding
    viewBinding {
        enable = true
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    // Jetpack Compose
    implementation ("androidx.compose.ui:ui:1.5.1")
    implementation ("androidx.compose.material3:material3:1.1.1")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.5.1")
    implementation ("androidx.activity:activity-compose:1.8.0")




    /* Dependencias de CameraX -- SEbas
    implementation("androidx.camera:camera-core:1.2.0")
    implementation("androidx.camera:camera-camera2:1.2.0")
    implementation("androidx.camera:camera-lifecycle:1.2.0")
    implementation("androidx.camera:camera-view:1.2.0")
    // Dependencia de ML Kit para el escaneo de códigos QR
    //implementation("com.google.mlkit:barcode-scanning:17.0.0")
*/

    // ML Kit Barcode Scanning
    implementation("com.google.mlkit:barcode-scanning:17.3.0")

    // CameraX
    implementation("androidx.camera:camera-core:1.4.1")
    implementation("androidx.camera:camera-camera2:1.4.1")
    implementation("androidx.camera:camera-lifecycle:1.4.1")
    implementation("androidx.camera:camera-view:1.2.1")

    // Debugging tools for Compose
    //debugImplementation ("androidx.compose.ui:ui-tooling:1.5.1")
    //debugImplementation ("androidx.compose.ui:ui-test-manifest:1.5.1")
     //Otras librerias
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")


    // 3D and ARCore
    implementation("io.github.sceneview:arsceneview:0.10.0")


    // Firebase
    implementation(platform("com.google.firebase:firebase-bom:32.0.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-firestore")


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}