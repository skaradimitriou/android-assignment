package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

data class Market(
    val betItems: List<BetItem>?,
    val betTypeSysname: String?,
    val marketId: Int?
) : LocalModel {
    override fun equalsContent(data: LocalModel): Boolean = false
}