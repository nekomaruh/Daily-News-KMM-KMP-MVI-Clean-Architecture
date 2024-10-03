package com.example.dailypals.articles

import com.example.dailypals.BaseViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class ArticlesViewModel(
    val articlesUseCase: ArticlesUseCase
) : BaseViewModel() {
    private val _articlesState = MutableStateFlow<ArticlesState>(ArticlesState())
    val articlesState: StateFlow<ArticlesState> = _articlesState

    init {
        getArticles()
    }

    private fun getArticles() = scope.launch {
        _articlesState.value = ArticlesState(loading = true)
        delay(1000)
        val articles = articlesUseCase.getArticles()
        _articlesState.emit(ArticlesState(articles = articles))
    }

    /*
    suspend fun fetchArticles(): List<Article> {
        return mockArticles
    }

    private val mockArticles = listOf(
        Article(
            title = "Title 1",
            description = "Description 1",
            date = "Date 1",
            imageUrl = "Image 1"
        ),
        Article(
            title = "Title 2",
            description = "Description 2",
            date = "Date 2",
            imageUrl = "Image 2"
        ),
        Article(
            title = "Title 3",
            description = "Description 3",
            date = "Date 3",
            imageUrl = "Image 3"
        )
    )*/
}