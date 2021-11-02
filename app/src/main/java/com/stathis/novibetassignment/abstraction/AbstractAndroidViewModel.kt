package com.stathis.novibetassignment.abstraction

import android.app.Application
import androidx.lifecycle.AndroidViewModel

abstract class AbstractAndroidViewModel(app : Application) : AndroidViewModel(app) {

    /*
     * The purpose of this abstract viewmodel is that we can call getString()
     *  when we implement this class
     */

    fun getString(resId: Int) = getApplication<Application>().getString(resId)
}