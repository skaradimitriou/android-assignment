package com.stathis.novibetassignment.ui

import android.app.Application
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.google.gson.Gson
import com.stathis.novibetassignment.R
import com.stathis.novibetassignment.abstraction.AbstractAndroidViewModel
import com.stathis.novibetassignment.callbacks.ItemClickListener
import com.stathis.novibetassignment.callbacks.MainScreenCallback
import com.stathis.novibetassignment.models.*
import com.stathis.novibetassignment.network.ApiClient
import com.stathis.novibetassignment.network.SessionManager
import com.stathis.novibetassignment.ui.holders.MainScreenAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel(app: Application) : AbstractAndroidViewModel(app), ItemClickListener {

    val adapter = MainScreenAdapter(this)
    val gamesAdapter = MainScreenAdapter(this)
    private val sessionManager = SessionManager(app)
    val games = MutableLiveData<List<EventsItem>>()
    val headlines = MutableLiveData<List<BetViewItem>>()
    val isLoading = MutableLiveData<Boolean>()
    val errorResponse = MutableLiveData<Boolean>()
    private lateinit var callback: MainScreenCallback

    fun pushLoginData() {
        val json = JSONObject().also {
            it.put(getString(R.string.username), getString(R.string.name))
            it.put(getString(R.string.password), getString(R.string.surname))
        }

        ApiClient.login(json.toString()).enqueue(object : Callback<TokenResponse> {
            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                val result = response.body()
                val code = response.code()
                when (code == 200) {
                    true -> sessionManager.saveAuthToken(result!!.token_type)
                }

                errorResponse.value = false
            }

            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                //
            }
        })
    }

    fun getHeadlines() {
        ApiClient.getUpdatedHeadlines(token = "Bearer ${sessionManager.fetchAuthToken()}")
            .enqueue(object : Callback<List<UpdatedHeadlinesItem>> {
                override fun onResponse(
                    call: Call<List<UpdatedHeadlinesItem>>,
                    response: Response<List<UpdatedHeadlinesItem>>
                ) {
                    val result = response.body()?.first()?.betViews
                    headlines.value = result
                    errorResponse.value = false
                }

                override fun onFailure(call: Call<List<UpdatedHeadlinesItem>>, t: Throwable) {
                    errorResponse.value = true
                }
            })
    }

    fun getGames() {
        ApiClient.getUpdatedGames(token = "Bearer ${sessionManager.fetchAuthToken()}")
            .enqueue(object : Callback<List<UpdatedGamesItem>> {
                override fun onResponse(
                    call: Call<List<UpdatedGamesItem>>,
                    response: Response<List<UpdatedGamesItem>>
                ) {
                    val events =
                        response.body()?.first()?.betviews?.first()?.competitions?.first()?.events
                    games.value = events
                    errorResponse.value = false
                }

                override fun onFailure(call: Call<List<UpdatedGamesItem>>, t: Throwable) {
                    errorResponse.value = true
                }
            })
    }

    fun observe(owner: LifecycleOwner, callback: MainScreenCallback) {
        this.callback = callback

        games.observe(owner, Observer {
            gamesAdapter.submitList(it)
        })

        headlines.observe(owner, Observer {
            adapter.submitList(it)
        })
    }

    fun release(owner: LifecycleOwner) {
        games.removeObservers(owner)
        headlines.removeObservers(owner)
    }

    override fun onItemTap(view: View) {
        when (view.tag) {
            is BetViewItem -> callback.onHeadlineTap(view.tag as BetViewItem)
            is EventsItem -> callback.onGameTap(view.tag as EventsItem)
        }
    }
}