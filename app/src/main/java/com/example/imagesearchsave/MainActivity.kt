package com.example.imagesearchsave

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imagesearchsave.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}