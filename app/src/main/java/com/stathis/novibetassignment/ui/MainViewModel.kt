package com.stathis.novibetassignment.ui

import android.app.Application
import android.util.Log
import com.stathis.novibetassignment.abstraction.AbstractAndroidViewModel
import com.stathis.novibetassignment.models.LoginData
import com.stathis.novibetassignment.models.TokenResponse
import com.stathis.novibetassignment.models.UpdatedGames
import com.stathis.novibetassignment.models.UpdatedHeadlines
import com.stathis.novibetassignment.network.ApiClient
import com.stathis.novibetassignment.network.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel(app : Application) : AbstractAndroidViewModel(app) {

    private val sessionManager = SessionManager(app)

    fun pushLoginData(){
        val loginData = LoginData("efstathios", "karadimitriou")

        ApiClient.login(loginData).enqueue(object : Callback<TokenResponse> {
            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                val result = response.body()
                val code = response.code()
                when(code == 200){
                    true -> sessionManager.saveAuthToken(result!!.token_type)
                }
            }

            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                Log.d("","")
            }
        })
    }

    fun getData(){
        getHeadlines()
        getGames()
    }

    private fun getHeadlines(){
        ApiClient.getUpdatedHeadlines(token = "Bearer ${sessionManager.fetchAuthToken()}").enqueue(object : Callback<UpdatedHeadlines> {
            override fun onResponse(call: Call<UpdatedHeadlines>, response: Response<UpdatedHeadlines>) {
                val result = response.body()
                val code = response.code()
            }

            override fun onFailure(call: Call<UpdatedHeadlines>, t: Throwable) {
                Log.d("","")
            }
        })
    }

    private fun getGames(){
        ApiClient.getUpdatedGames(token = "Bearer ${sessionManager.fetchAuthToken()}").enqueue(object : Callback<UpdatedGames> {
            override fun onResponse(call: Call<UpdatedGames>, response: Response<UpdatedGames>) {
                val result = response.body()
                val code = response.code()
            }

            override fun onFailure(call: Call<UpdatedGames>, t: Throwable) {
                Log.d("","")
            }
        })
    }
}