package com.stathis.novibetassignment.network

import com.stathis.novibetassignment.models.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface Endpoints {

    @POST("5d8e4bd9310000a2612b5448/login")
    fun login(@Body loginData : String) : Call<TokenResponse>

    @GET("5d7114b2330000112177974d")
    fun getUpdatedGames(@Header("Authorization") token : String): Call<List<UpdatedGamesItem>>

    @GET("5d711461330000d135779748")
    fun getUpdatedHeadlines(@Header("Authorization") token : String): Call<List<UpdatedHeadlinesItem>>
}