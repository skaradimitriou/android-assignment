package com.stathis.novibetassignment.util

import android.content.Context
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.stathis.novibetassignment.R

class MySnackbars {

    /*
     * Handling success, info & warning cases
     */

    fun showSuccessSnack(view: View, context: Context, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).also {
            it.setBackgroundTint(context.getColor(R.color.success_green))
            it.show()
        }
    }

    fun showErrorSnack(view: View, context: Context, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).also {
            it.setBackgroundTint(context.getColor(R.color.novibet_red))
            it.show()
        }
    }

    fun showInfoSnack(view: View, context: Context, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).also {
            it.setBackgroundTint(context.getColor(R.color.orange))
            it.show()
        }
    }
}