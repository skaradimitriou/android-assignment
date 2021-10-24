package com.stathis.novibetassignment.ui

import android.os.Handler
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.stathis.novibetassignment.R
import com.stathis.novibetassignment.abstraction.SimplifiedActivity
import kotlinx.android.synthetic.main.activity_main.*
import androidx.viewpager2.widget.ViewPager2.SCROLL_STATE_IDLE
import com.stathis.novibetassignment.callbacks.MainScreenCallback
import com.stathis.novibetassignment.models.BetViewItem
import com.stathis.novibetassignment.models.EventsItem
import com.stathis.novibetassignment.util.MySnackbars


class MainActivity : SimplifiedActivity(R.layout.activity_main) {

    private lateinit var viewModel: MainViewModel
    private val sliderHandler = Handler()

    override fun init() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        supportActionBar?.title = resources.getString(R.string.main_screen_title)
    }

    override fun startOps() {
        viewModel.pushLoginData()
        viewModel.getHeadlines()
        viewModel.getGames()

        games_recycler.adapter = viewModel.gamesAdapter
        headlines_recycler.adapter = viewModel.adapter

        headlines_recycler.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable, 5000)
            }

            override fun onPageScrollStateChanged(state: Int) {
                when (state == SCROLL_STATE_IDLE) {
                    true -> sliderHandler.postDelayed(sliderRunnable, 5000)
                }
            }
        })

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.observe(this, object : MainScreenCallback {
            override fun onHeadlineTap(headline: BetViewItem) {
                //Enter code here for callback on user tap
            }

            override fun onGameTap(event: EventsItem) {
                //Enter code here for callback on user tap
            }
        })

        viewModel.errorLoginResponse.observe(this, Observer {
            when (it) {
                true -> notifyUser(getString(R.string.error_login_credentials))
                false -> Unit
            }
        })

        viewModel.errorGamesResponse.observe(this, Observer {
            when (it) {
                true -> notifyUser(getString(R.string.error_games_data))
                false -> Unit
            }
        })

        viewModel.errorHeadlinesResponse.observe(this, Observer {
            when (it) {
                true -> notifyUser(getString(R.string.error_headlines_data))
                false -> Unit
            }
        })
    }

    override fun stopOps() {
        viewModel.errorLoginResponse.removeObservers(this)
        viewModel.errorHeadlinesResponse.removeObservers(this)
        viewModel.errorGamesResponse.removeObservers(this)
        viewModel.release(this)
    }

    private val sliderRunnable = Runnable {
        when (headlines_recycler.currentItem == viewModel.adapter.itemCount - 1) {
            true -> headlines_recycler.currentItem = 0
            else -> headlines_recycler.currentItem = headlines_recycler.currentItem + 1
        }
    }

    private fun notifyUser(message: String) {
        MySnackbars().showErrorSnack(findViewById(R.id.main_screen_parent), this, message)
    }
}