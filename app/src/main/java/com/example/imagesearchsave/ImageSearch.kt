package com.example.imagesearchsave

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ImageSearch : AppCompatActivity() {
    private val binding by lazy { FragmentSearchBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}