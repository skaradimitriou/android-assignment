package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

data class BetView(
    val betViewKey: String?,
    val competitionContextCaption: String?,
    val competitions: List<Competition>?,
    val marketCaptions: List<MarketCaption>?,
    val modelType: String?,
    val totalCount: Int?
) : LocalModel {
    override fun equalsContent(data: LocalModel): Boolean = false
}