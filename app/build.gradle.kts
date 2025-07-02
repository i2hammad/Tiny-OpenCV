plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    namespace = "com.zynkware.tinyopencv"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.zynkware.tinyopencv"
        minSdk = 21
        targetSdk = 36
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        externalNativeBuild {
            cmake {
                abiFilters("x86", "x86_64", "armeabi-v7a", "arm64-v8a")
                arguments("-DOpenCV_DIR=${projectDir.absolutePath}/../openCV440/src/main/jniLibs")
                targets("opencv_jni_shared")
            }
        }
    }

    buildTypes {
        getByName("release") {
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

    externalNativeBuild {
        cmake {
            path = File(projectDir, "libcxx_helper/CMakeLists.txt")
        }
    }
    ndkVersion = "27.2.12479018"
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(libs.kotlin.stdlib)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(project(":openCV"))
}
