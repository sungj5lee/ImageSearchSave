package com.example.imagesearchsave

import android.R
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.imagesearchsave.API.ImageSearchResponse
import com.example.imagesearchsave.databinding.FragmentSearchBinding
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import java.time.LocalDateTime


interface RetrofitService{

    //post2
    // 호출하는 곳에서 매개변수를 HashMap 형태로 보내는 방식
    @GET("v2/search/image")
    fun testRequest(
        @Header("Authorization") key: String,
        @Query("query") query : String,
        @Query("sort") sort : String,
        @Query("page") page : Int,
        @Query("size") size : Int
    ): Call<ImageSearchResponse>
}

class ImageSearch : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemList= mutableListOf<Item>()
        val adapter = RecyclerAdapter(mContext)
        binding.rvSearch.adapter = adapter
        binding.rvSearch.layoutManager = GridLayoutManager(requireContext(), 2)
        val goon = GsonBuilder().setLenient().create()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dapi.kakao.com")
            .addConverterFactory(GsonConverterFactory.create(goon))
            .build()

        val server: RetrofitService = retrofit.create(RetrofitService::class.java)

        //post2
        // 호출하는 곳에서 매개변수를 HashMap 형태로 보내는 방식

        var APIkey="KakaoAK b873a488f793d5365348c7ac2943dfec"

        var repos = server.testRequest("KakaoAK b873a488f793d5365348c7ac2943dfec", "설현", "accuracy", 1, 80)
        repos.enqueue(object : Callback<ImageSearchResponse>{
            override fun onFailure(call: Call<ImageSearchResponse>?, t: Throwable?) {
                Log.e("Retrofit", t.toString())
            }

            override fun onResponse(call: Call<ImageSearchResponse>?, response: Response<ImageSearchResponse>?) {
                response?.body()?.documents?.forEach {
                    itemList.add(Item(it.image_url, it.title, it.datetime))
                }
                Log.d("help me", response.toString())
                adapter.items=itemList
                adapter.notifyDataSetChanged()
            }
        })
    }
}