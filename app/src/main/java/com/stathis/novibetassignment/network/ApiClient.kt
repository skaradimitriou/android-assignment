package com.stathis.novibetassignment.network

import com.stathis.novibetassignment.models.*
import com.stathis.novibetassignment.util.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val service: Endpoints = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Endpoints::class.java)

    fun getUpdatedGames(token: String): Call<List<UpdatedGamesItem>> {
        return service.getUpdatedGames(token)
    }

    fun getUpdatedHeadlines(token: String): Call<List<UpdatedHeadlinesItem>> {
        return service.getUpdatedHeadlines(token)
    }

    fun login(loginData: String): Call<TokenResponse> {
        return service.login(loginData)
    }
}