package com.example.dailypals.articles

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get


class ArticlesService(private val client: HttpClient) {
    private val country = "us"
    private val articleCategory = "business"
    private val apiKey = "2a8e9f6606f44d33af58536dd9721a18"

    suspend fun getArticles(): List<ArticleRaw> {
        val response =
            client.get("https://newsapi.org/v2/top-headlines?country=$country&category=$articleCategory&apiKey=$apiKey")
            
        print(response)
        return response.body<ArticlesResponse>().articles
    }
}