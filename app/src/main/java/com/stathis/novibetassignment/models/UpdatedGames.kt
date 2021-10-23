package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

class UpdatedGames(val betViews : UpdatedGamesItem) : LocalModel{
    override fun equalsContent(data: LocalModel): Boolean = false
}