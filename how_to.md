# Building OpenCV Android SDK with NDK 28 for API Level 26

This guide shows you how to build the OpenCV Android SDK (version 4.11.0) using NDK 28 for API level 26. The build produces a unified shared library **libopencv_java4.so** that contains the Java bindings along with only the **core**, **imgcodecs**, and **imgproc** modules.

---

## 1. Clone the Repository and Create a Build Directory

Open your terminal and run:

```bash
git clone git@github.com:opencv/opencv.git -b 4.11.0
cd opencv
mkdir build
cd build
```

---

## 2. Set Environment Variables

Adjust the following variables to match your local setup. In this example, we’re building for **x86_64** targeting API level **26**. (For other ABIs, set **TARGET_ABI** accordingly.)

```bash
export OPENCV_SRC_FOLDER=~/Personal/opencv
export OPENCV_BUILD_FOLDER=$OPENCV_SRC_FOLDER/build
export ANDROID_SDK=~/Android/Sdk
export ANDROID_NDK_HOME=$ANDROID_SDK/ndk/28.0.12916984
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk
export TARGET_ABI=x86_64 # armeabi-v7a, arm64-v8a, x86, x86_64
export API_LEVEL=26
```

---

## 3. Configure the Build with CMake

Run the following CMake command. This command:
- Uses the NDK’s toolchain file.
- Sets the ABI and API level.
- Uses the static C++ runtime.
- Enables the unified Java library target (**BUILD_opencv_java=ON**).
- Disables tests, performance tests, examples, and Android projects.
- Limits the build to the **core**, **imgcodecs**, and **imgproc** modules.
- Uses shared libraries overall (so the Java target is built as a shared library) with optimization flags.
- Disables third-party dependencies like IPP, TBB, CUDA, and OpenCL.

```bash
cmake \
  -DCMAKE_TOOLCHAIN_FILE=$ANDROID_NDK_HOME/build/cmake/android.toolchain.cmake \
  -DANDROID_ABI=$TARGET_ABI \
  -DANDROID_PLATFORM=android-$API_LEVEL \
  -DBUILD_LIST=core,imgproc,java \
  -DBUILD_EXAMPLES=OFF \
  -DBUILD_ANDROID_EXAMPLES=OFF \
  -DBUILD_TESTS=OFF \
  -DBUILD_PERF_TESTS=OFF \
  -DBUILD_DOCS=OFF \
  -DBUILD_opencv_java=ON \
  -DBUILD_opencv_java_bindings_generator=ON \
  -DCMAKE_BUILD_TYPE=Release \
  -DBUILD_SHARED_LIBS=OFF \
  -DWITH_IPP=OFF \
  -DWITH_IPP_A=OFF \
  -DWITH_ITT=OFF \
  -DWITH_TBB=OFF \
  -DWITH_OPENCL=OFF \
  ..
```

This configuration tells OpenCV’s build system to compile only the selected modules and generate the Java bindings target (which will produce **libopencv_java4.so**).

---

## 4. Build the Unified Java Library

Invoke the build command to compile the **opencv_java** target:

```bash
cmake --build . --target opencv_java -j$(nproc)
```

After the build completes, the unified library (for **$TARGET_ABI**) should be generated—typically at a location like:

```
jni/$TARGET_ABI/libopencv_java4.so
```

---

## 5. Strip Unneeded Symbols

Reduce the size of the generated library by stripping unneeded symbols using the NDK’s llvm-strip tool:

```bash
$ANDROID_NDK_HOME/toolchains/llvm/prebuilt/linux-x86_64/bin/llvm-strip --strip-unneeded jni/$TARGET_ABI/libopencv_java4.so
```

---

## 6. Using the Library in Your Android Project

Copy the resulting **libopencv_java4.so** into your Android project’s JNI libraries folder (e.g. `app/src/main/jniLibs/$TARGET_ABI/`). Then, in your Java or Kotlin code, load the library as follows:

```java
static {
    System.loadLibrary("opencv_java4");
}
```
