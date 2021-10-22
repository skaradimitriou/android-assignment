package com.stathis.novibetassignment.models

data class Event(
    val additionalCaptions: AdditionalCaptions?,
    val betContextId: Int?,
    val hasBetContextInfo: Boolean?,
    val isHighlighted: Boolean?,
    val liveData: LiveData?,
    val markets: List<Market>?,
    val path: String?
)