package com.example.developeramit.newsample.data

import com.example.developeramit.newsample.data.Channel


data class Video(
    val id: Int,
    val name: String,
    val link: String,
    val imageUrl: String,
    val numberOfViews: Int,
    val channel: Channel
)