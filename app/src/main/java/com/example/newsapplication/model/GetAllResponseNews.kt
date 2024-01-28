package com.example.newsapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GetAllResponseNews(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
) : Parcelable