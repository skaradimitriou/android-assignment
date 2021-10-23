package com.stathis.novibetassignment.network

import com.stathis.novibetassignment.models.*
import com.stathis.novibetassignment.util.BASE_URL
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
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

    fun getUpdatedGames(token : String): Call<List<UpdatedGamesItem>> {
        return api.getUpdatedGames(token)
    }

    fun getUpdatedHeadlines(token : String): Call<List<UpdatedHeadlinesItem>> {
        return api.getUpdatedHeadlines(token)
    }

    fun login(loginData: LoginData) : Call<TokenResponse>{
        return api.login(loginData)
    }
}