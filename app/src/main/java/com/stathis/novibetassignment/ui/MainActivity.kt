package com.stathis.novibetassignment.ui

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.stathis.novibetassignment.R
import com.stathis.novibetassignment.abstraction.SimplifiedActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : SimplifiedActivity(R.layout.activity_main) {

    private lateinit var viewModel: MainViewModel

    override fun init() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun startOps() {
        viewModel.pushLoginData()
        viewModel.getData()

        headlines_recycler.adapter = viewModel.adapter
        games_recycler.adapter = viewModel.adapter

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.observe(this)
        viewModel.isLoading.observe(this, Observer {
            when(it){
                true -> {} // data is loading. do something
                false -> {}
            }
        })

        viewModel.errorResponse.observe(this,Observer{
            when(it){
                true -> {} //there is an error with data from api
                false -> Unit
            }
        })
    }

    override fun stopOps() {
        viewModel.isLoading.removeObservers(this)
    }
}