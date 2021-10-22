package com.stathis.novibetassignment.models

data class BetView(
    val betViewKey: String?,
    val competitionContextCaption: String?,
    val competitions: List<Competition>?,
    val marketCaptions: List<MarketCaption>?,
    val modelType: String?,
    val totalCount: Int?
)