package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

data class Competition(
    val betContextId: Int?,
    val caption: String?,
    val events: List<Event>?,
    val regionCaption: String?
) : LocalModel {
    override fun equalsContent(data: LocalModel): Boolean = false
}