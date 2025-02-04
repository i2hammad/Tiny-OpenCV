# Tiny-OpenCV

A tiny version of [OpenCV](https://opencv.org). AAR size: ~15.1 MB

- tiny version of OpenCV **4.11.0**:
    - arm64-v8a: **7.6 MB** (original: 21.6 MB)
    - armeabi-v7a: **5.0 MB** (original: 14.8 MB)
    - x86: **9.4 MB** (original: 39.5 MB)
    - x86_64: **10.7 MB** (original: 53.2 MB)

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
