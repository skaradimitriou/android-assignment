package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

data class LiveDataItem(
    val elapsed : String,
    val elapsedSeconds : String,
    val isInPlay : Boolean
) : LocalModel{
    override fun equalsContent(data: LocalModel): Boolean = false
}
