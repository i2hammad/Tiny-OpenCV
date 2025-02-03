# Tiny-OpenCV

A tiny version of [OpenCV](https://opencv.org). AAR size: ~26 MB

- tiny version of OpenCV **4.11.0**:
    - armeabi-v7a: **3.1 MB** (original: 14.8 MB)
    - arm64-v8a: **5.6 MB** (original: 21.6 MB)
    - x86: **16.7 MB** (original: 39.5 MB)
    - x86_64: **25.1 MB** (original: 53.2 MB)

## Installation

In your app gradle:

    dependencies {
        ...
        implementation 'com.github.hazzatur:TinyOpenCV:4.11.0'
    }

In your root gradle:

	allprojects {
	    repositories {
		...
		maven { url "https://jitpack.io" }
	    }
	}
