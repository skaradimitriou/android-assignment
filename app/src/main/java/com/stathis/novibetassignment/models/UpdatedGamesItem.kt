package com.stathis.novibetassignment.models

data class UpdatedGamesItem(
    val betViews: List<BetView>?,
    val caption: String?,
    val hasHighlights: Boolean?,
    val marketViewKey: String?,
    val marketViewType: String?,
    val modelType: String?,
    val totalCount: Int?
)