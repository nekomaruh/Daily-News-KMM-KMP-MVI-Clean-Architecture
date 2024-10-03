package com.example.dailypals.articles

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val service: ArticlesService
) {
    suspend fun getAllArticles(): List<ArticleRaw> {
        val list = dataSource.getAllArticles()
        if (list.isEmpty()) {
            val articles = service.getArticles()
            dataSource.insertArticles(articles)
            return articles
        }
        return list
    }
}