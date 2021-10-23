package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

data class BetViewItem (
    val betContextId : Int?,
    val marketViewGroupId : Int?,
    val marketViewId : Int?,
    val rootMarketViewGroupId : Int?,
    val path : String?,
    val startTime : String?,
    val competitor1Caption : String?,
    val competitor2Caption : String?,
    val title : String?,
    val text : String?

) : LocalModel{
    override fun equalsContent(data: LocalModel): Boolean = false
}