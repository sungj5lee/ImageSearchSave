package com.example.imagesearchsave

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.imagesearchsave.databinding.FragmentSearchBinding
import java.io.File
import java.time.LocalDateTime

class ImageSearch : AppCompatActivity() {
    private val binding by lazy { FragmentSearchBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemList= mutableListOf<Item>(
            Item(Uri.fromFile(File("ic_launcher_background.xml")),"asdf", LocalDateTime.now())
        )

        val adapter = RecyclerAdapter(itemList)
        binding.rvSearch.adapter = adapter
        binding.rvSearch.layoutManager = GridLayoutManager(this, 2)
    }
}