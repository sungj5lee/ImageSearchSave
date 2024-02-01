package com.example.imagesearchsave

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imagesearchsave.databinding.FragmentSaveBinding

class ImageSave : AppCompatActivity() {
    private val binding by lazy { FragmentSaveBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}