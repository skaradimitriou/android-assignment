package com.stathis.novibetassignment.callbacks

import com.stathis.novibetassignment.models.BetViewItem
import com.stathis.novibetassignment.models.EventsItem

interface MainScreenCallback {
    fun onHeadlineTap(headline : BetViewItem)
    fun onGameTap(event : EventsItem)
}