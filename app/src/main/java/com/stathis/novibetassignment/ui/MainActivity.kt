package com.stathis.novibetassignment.ui

import android.os.Handler
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.stathis.novibetassignment.R
import com.stathis.novibetassignment.abstraction.SimplifiedActivity
import kotlinx.android.synthetic.main.activity_main.*
import androidx.viewpager.widget.ViewPager


class MainActivity : SimplifiedActivity(R.layout.activity_main) {

    private lateinit var viewModel: MainViewModel
    private val sliderHandler = Handler()
    var count = 0

    override fun init() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun startOps() {
        viewModel.pushLoginData()
        viewModel.getHeadlines()
        viewModel.getGames()

        headlines_recycler.adapter = viewModel.adapter

        headlines_recycler.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable, 2500)
            }
        })
        games_recycler.adapter = viewModel.gamesAdapter

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.observe(this)
        viewModel.isLoading.observe(this, Observer {
            when (it) {
                true -> {
                } // data is loading. do something
                false -> {
                }
            }
        })

        viewModel.errorResponse.observe(this, Observer {
            when (it) {
                true -> {
                } //there is an error with data from api
                false -> Unit
            }
        })

    }

    override fun stopOps() {
        viewModel.isLoading.removeObservers(this)
        viewModel.release(this)
    }

    private val sliderRunnable = Runnable {
        headlines_recycler.currentItem = headlines_recycler.currentItem + 1
    }
}