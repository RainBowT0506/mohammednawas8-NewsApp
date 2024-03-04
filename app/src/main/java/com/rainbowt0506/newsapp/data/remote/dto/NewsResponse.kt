package com.rainbowt0506.newsapp.data.remote.dto

import com.rainbowt0506.newsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)