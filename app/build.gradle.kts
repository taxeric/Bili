plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.lanier.bili"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.lanier.bili"
        minSdk = 28
        targetSdk = 33
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

    sourceSets {
        named("main") {
            res.srcDirs(
                "src/main/res/layout/login",
                "src/main/res/layout/main",
                "src/main/res/layout",
                "src/main/res",
            )
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation(project(":lib_core"))

    val jackson_version = "2.15.2"
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jackson_version")

    //vm & lifecycle
    val lifecycle_version = "2.6.2"
    val act_ktx_version = "1.7.2"
    val fra_ktx_version = "1.6.1"
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    implementation("androidx.activity:activity-ktx:$act_ktx_version")
    implementation("androidx.fragment:fragment-ktx:$fra_ktx_version")
}