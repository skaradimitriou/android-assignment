package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

data class UpdatedHeadlinesItem(
    val betViews: List<BetViewX>?,
    val caption: String?,
    val marketViewKey: String?,
    val marketViewType: String?,
    val modelType: String?
): LocalModel {
    override fun equalsContent(data: LocalModel): Boolean = false
}