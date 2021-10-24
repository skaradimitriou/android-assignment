package com.stathis.novibetassignment.ui

import android.app.Application
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.stathis.novibetassignment.R
import com.stathis.novibetassignment.abstraction.AbstractAndroidViewModel
import com.stathis.novibetassignment.callbacks.ItemClickListener
import com.stathis.novibetassignment.callbacks.MainScreenCallback
import com.stathis.novibetassignment.models.*
import com.stathis.novibetassignment.ui.holders.MainScreenAdapter
import org.json.JSONObject


class MainViewModel(app: Application) : AbstractAndroidViewModel(app), ItemClickListener {

    val adapter = MainScreenAdapter(this)
    val gamesAdapter = MainScreenAdapter(this)
    val games = MutableLiveData<List<EventsItem>>()
    val headlines = MutableLiveData<List<BetViewItem>>()
    val errorLoginResponse = MutableLiveData<Boolean>()
    val errorGamesResponse = MutableLiveData<Boolean>()
    val errorHeadlinesResponse = MutableLiveData<Boolean>()
    private lateinit var callback: MainScreenCallback
    private val repo = MainRepository(app)

    /*
       FIXME: Add coroutines (?)
     */

    fun pushLoginData() {
        val json = JSONObject().also {
            it.put(getString(R.string.username), getString(R.string.name))
            it.put(getString(R.string.password), getString(R.string.surname))
        }

        repo.pushLoginData(json.toString(), errorLoginResponse)
    }

    fun getHeadlines() {
        repo.getHeadlines(headlines, errorHeadlinesResponse)
    }

    fun getGames() {
        repo.getGames(games, errorGamesResponse)
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