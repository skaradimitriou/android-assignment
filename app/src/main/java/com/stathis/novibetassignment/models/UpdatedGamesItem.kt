package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

data class UpdatedGamesItem(
    val betViews: List<BetView>?,
    val caption: String?,
    val hasHighlights: Boolean?,
    val marketViewKey: String?,
    val marketViewType: String?,
    val modelType: String?,
    val totalCount: Int?
) : LocalModel {
    override fun equalsContent(data: LocalModel): Boolean = false
}