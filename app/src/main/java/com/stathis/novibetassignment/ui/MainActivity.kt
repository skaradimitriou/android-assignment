package com.stathis.novibetassignment.ui

import androidx.lifecycle.ViewModelProvider
import com.stathis.novibetassignment.R
import com.stathis.novibetassignment.abstraction.SimplifiedActivity

class MainActivity : SimplifiedActivity(R.layout.activity_main) {

    private lateinit var viewModel : MainViewModel

    override fun init() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun startOps() {
       //
    }

    override fun stopOps() {
        //
    }

}