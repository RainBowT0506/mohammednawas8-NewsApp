package com.rainbowt0506.newsapp.domain.usecases.news

import com.rainbowt0506.newsapp.data.local.NewsDao
import com.rainbowt0506.newsapp.domain.model.Article
import com.rainbowt0506.newsapp.domain.repository.NewsRepository

class SelectArticle(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(url: String): Article? {
        return newsRepository.selectArticle(url)
    }
}