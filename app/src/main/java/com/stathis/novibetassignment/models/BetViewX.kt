package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

data class BetViewX(
    val betContextId: Int?,
    val betItems: Any?,
    val betViewKey: String?,
    val competitor1Caption: String?,
    val competitor2Caption: String?,
    val displayFormat: String?,
    val imageId: Int?,
    val liveData: LiveDataX?,
    val marketTags: List<Any>?,
    val marketViewGroupId: Int?,
    val marketViewId: Int?,
    val modelType: String?,
    val path: String?,
    val rootMarketViewGroupId: Int?,
    val startTime: String?,
    val text: String?,
    val title: String?,
    val url: Any?
) : LocalModel {
    override fun equalsContent(data: LocalModel): Boolean = false
}