package com.example.dailypals.articles.data

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val service: ArticlesService
) {
    suspend fun getAllArticles(forceFetch: Boolean): List<ArticleRaw> {
        if (forceFetch) {
            dataSource.removeAllArticles()
            return getArticles()
        }
        val list = dataSource.getAllArticles()
        if (list.isEmpty()) {
            return getArticles()
        }
        return list
    }

    private suspend fun getArticles(): List<ArticleRaw> {
        val articles = service.getArticles()
        dataSource.insertArticles(articles)
        return articles
    }
}