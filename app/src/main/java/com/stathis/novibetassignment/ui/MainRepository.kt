package com.stathis.novibetassignment.ui

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.stathis.novibetassignment.models.*
import com.stathis.novibetassignment.network.ApiClient
import com.stathis.novibetassignment.network.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository(context: Context) {

    private val sessionManager = SessionManager(context)

    fun pushLoginData(userData : String,errorLoginResponse : MutableLiveData<Boolean>) {
        ApiClient.login(userData).enqueue(object : Callback<TokenResponse> {
            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                val result = response.body()
                val code = response.code()
                when (code == 200) {
                    true -> sessionManager.saveAuthToken(result!!.token_type)
                }

                errorLoginResponse.value = false
            }

            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                errorLoginResponse.value = true
            }
        })
    }

    fun getHeadlines(headlines : MutableLiveData<List<BetViewItem>>, errorHeadlinesResponse : MutableLiveData<Boolean>) {
        ApiClient.getUpdatedHeadlines(token = "${sessionManager.fetchAuthToken()}")
            .enqueue(object : Callback<List<UpdatedHeadlinesItem>> {
                override fun onResponse(
                    call: Call<List<UpdatedHeadlinesItem>>,
                    response: Response<List<UpdatedHeadlinesItem>>
                ) {
                    val result = response.body()?.first()?.betViews
                    headlines.value = result
                    errorHeadlinesResponse.value = false
                }

                override fun onFailure(call: Call<List<UpdatedHeadlinesItem>>, t: Throwable) {
                    errorHeadlinesResponse.value = true
                }
            })
    }

    fun getGames(games : MutableLiveData<List<EventsItem>>,errorGamesResponse : MutableLiveData<Boolean>) {
        ApiClient.getUpdatedGames(token = "${sessionManager.fetchAuthToken()}")
            .enqueue(object : Callback<List<UpdatedGamesItem>> {
                override fun onResponse(
                    call: Call<List<UpdatedGamesItem>>,
                    response: Response<List<UpdatedGamesItem>>
                ) {
                    val events = response.body()?.first()?.betviews?.first()?.competitions?.first()?.events

                    games.value = events
                    errorGamesResponse.value = false
                }

                override fun onFailure(call: Call<List<UpdatedGamesItem>>, t: Throwable) {
                    errorGamesResponse.value = true
                }
            })
    }
}