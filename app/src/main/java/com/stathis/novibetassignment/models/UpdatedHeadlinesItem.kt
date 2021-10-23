package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

data class UpdatedHeadlinesItem(val betViews : List<BetViewItem>) : LocalModel{
    override fun equalsContent(data: LocalModel): Boolean = false
}
