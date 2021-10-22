package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

data class BetItem(
    val caption: String?,
    val code: String?,
    val id: Int?,
    val instanceCaption: String?,
    val isAvailable: Boolean?,
    val oddsText: String?,
    val price: Double?
) : LocalModel {
    override fun equalsContent(data: LocalModel): Boolean = false
}