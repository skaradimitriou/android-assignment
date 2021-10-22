package com.stathis.novibetassignment.models

data class Competition(
    val betContextId: Int?,
    val caption: String?,
    val events: List<Event>?,
    val regionCaption: String?
)