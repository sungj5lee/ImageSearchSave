package com.example.imagesearchsave

import android.net.Uri
import java.time.LocalDateTime

data class Item(
    val img: String,
    val from: String,
    val time: LocalDateTime
) {
}