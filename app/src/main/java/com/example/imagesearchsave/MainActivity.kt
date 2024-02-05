package com.example.imagesearchsave

import android.R
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.imagesearchsave.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction() // 프래그먼트매니저를 통해 사용
        val fragment1 = ImageSearch() // 객체 생성
        val fragment2 = ImageSave()

        transaction.replace(binding.framelayMain.id, fragment1) //layout, 교체될 layout
        transaction.commit() //commit으로 저장 하지 않으면 화면 전환이 되지 않음

        binding.btnSearch.setOnClickListener {
            val newTransaction=supportFragmentManager.beginTransaction()
            newTransaction.replace(binding.framelayMain.id, fragment1).commit()
        }
        binding.btnSave.setOnClickListener {
            val newTransaction=supportFragmentManager.beginTransaction()
            newTransaction.replace(binding.framelayMain.id, fragment2).commit()
        }
    }
}