package com.example.newsapplication.model

data class GetAllResponseNews(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)