package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

class UpdatedGames(val results  : ArrayList<UpdatedGamesItem>) : LocalModel {
    override fun equalsContent(data: LocalModel): Boolean = false
}