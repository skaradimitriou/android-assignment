package com.stathis.novibetassignment.models

data class UpdatedHeadlinesItem(
    val betViews: List<BetViewX>?,
    val caption: String?,
    val marketViewKey: String?,
    val marketViewType: String?,
    val modelType: String?
)