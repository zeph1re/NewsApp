package com.example.newsapplication.ui.home

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapplication.model.GetAllResponseNews
import com.example.newsapplication.network.ApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    var newsData : MutableLiveData<GetAllResponseNews?> = MutableLiveData()

    var newsHeadlinesData : MutableLiveData<GetAllResponseNews?> = MutableLiveData()

    fun getAllNews() {
        ApiClient.INSTANCE.getAllNewsData()
            .enqueue(object : Callback<GetAllResponseNews> {
                override fun onResponse(
                    call: Call<GetAllResponseNews>,
                    response: Response<GetAllResponseNews>,
                ) {
                    if (response.isSuccessful){
                        newsData.postValue(response.body())
                    } else{
                        newsData.postValue(null)
                    }
                }

                override fun onFailure(call: Call<GetAllResponseNews>, t: Throwable) {
                    newsData.postValue(null)
                }

            })
    }

    fun getHeadlines() {
        ApiClient.INSTANCE.getHeadlines()
            .enqueue(object : Callback<GetAllResponseNews> {
                override fun onResponse(
                    call: Call<GetAllResponseNews>,
                    response: Response<GetAllResponseNews>,
                ) {
                    if(response.isSuccessful){
                        newsHeadlinesData.postValue(response.body())
                    } else {
                        newsHeadlinesData.postValue(null)
                    }
                }

                override fun onFailure(call: Call<GetAllResponseNews>, t: Throwable) {
                    newsHeadlinesData.postValue(null)

                }

            })
    }
}