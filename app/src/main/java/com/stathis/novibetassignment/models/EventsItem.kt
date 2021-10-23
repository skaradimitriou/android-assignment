package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

data class EventsItem (

    val betContextId : Int,
    val path : String,
    val isHighlighted : Boolean,
    val additionalCaptions : AdditionalCaptionsItem,
    val liveData : LiveDataItem

) : LocalModel{
    override fun equalsContent(data: LocalModel): Boolean = false
}
