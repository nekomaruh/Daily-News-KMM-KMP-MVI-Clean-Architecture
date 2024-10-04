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

    fun getArticles(forceFetch: Boolean = false) = scope.launch {
        _articlesState.value = ArticlesState(
            loading = true,
            articles = _articlesState.value.articles
        )
        delay(1000)
        val articles = articlesUseCase.getArticles(forceFetch)
        _articlesState.emit(ArticlesState(articles = articles))
    }
}