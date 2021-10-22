package com.stathis.novibetassignment.network

import com.stathis.novibetassignment.models.UpdatedGames
import com.stathis.novibetassignment.models.UpdatedHeadlines
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/gamesupdate")
    fun getUpdatedGames(): Call<UpdatedGames>

    @GET("/headlinesupdate")
    fun getUpdatedHeadlines(): Call<UpdatedHeadlines>
}