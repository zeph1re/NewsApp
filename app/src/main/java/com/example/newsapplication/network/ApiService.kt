package com.example.newsapplication.network


import com.example.newsapplication.model.Article
import com.example.newsapplication.model.GetAllResponseNews
import com.example.newsapplication.utils.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("everything")
    fun getAllNewsData (
        @Query("q") query: String = "bitcoin",
        @Query("apiKey") apiKey: String = Constant.apiKey
    ) : Call<GetAllResponseNews>











}