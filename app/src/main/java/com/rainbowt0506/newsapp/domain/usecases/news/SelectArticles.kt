package com.rainbowt0506.newsapp.domain.usecases.news

import com.rainbowt0506.newsapp.data.local.NewsDao
import com.rainbowt0506.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticle()
    }
}