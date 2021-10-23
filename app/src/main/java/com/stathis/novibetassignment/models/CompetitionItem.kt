package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

data class CompetitionItem(

    val betContextId : Int,
    val caption : String,
    val regionCaption : String,
    val events : List<EventsItem>
) : LocalModel{
    override fun equalsContent(data: LocalModel): Boolean = false
}
