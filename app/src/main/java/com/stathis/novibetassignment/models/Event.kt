package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

data class Event(
    val additionalCaptions: AdditionalCaptions?,
    val betContextId: Int?,
    val hasBetContextInfo: Boolean?,
    val isHighlighted: Boolean?,
    val liveData: LiveData?,
    val markets: List<Market>?,
    val path: String?
) : LocalModel {
    override fun equalsContent(data: LocalModel): Boolean = false
}