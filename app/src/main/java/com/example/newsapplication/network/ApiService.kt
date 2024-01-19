package com.example.newsapplication.network

import retrofit2.http.GET

interface ApiService {

    @GET("everything")
    fun getAllNewsData()
}