package com.example.imagesearchsave.API

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class KakaoImage(
    @SerializedName("title")
    val title: String,

    @SerializedName("url")
    val image_url : String,

    @SerializedName("datetime")
    val datetime: LocalDateTime
)