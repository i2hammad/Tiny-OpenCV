package com.zynksoftware.tinyopencv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zynkware.tinyopencv.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        System.loadLibrary("opencv_java4")

    }
}