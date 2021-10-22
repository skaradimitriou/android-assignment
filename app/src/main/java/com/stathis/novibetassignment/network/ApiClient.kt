package com.stathis.novibetassignment.network

import com.stathis.novibetassignment.models.UpdatedGames
import com.stathis.novibetassignment.models.UpdatedHeadlines
import com.stathis.novibetassignment.util.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val api: ApiService

    init {
        api = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    fun getUpdatedGames(): Call<UpdatedGames> {
        return api.getUpdatedGames()
    }

    fun getUpdatedHeadlines(): Call<UpdatedHeadlines> {
        return api.getUpdatedHeadlines()
    }
}