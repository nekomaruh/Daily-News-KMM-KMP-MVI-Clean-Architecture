package com.example.dailypals.articles.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleRaw(
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String?,
    @SerialName("urlToImage")
    val imageUrl: String?,
    @SerialName("publishedAt")
    val date: String,
)