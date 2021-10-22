package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

data class QuarterScore(
    val awayScore: Int?,
    val caption: String?,
    val homeScore: Int?
) : LocalModel {
    override fun equalsContent(data: LocalModel): Boolean = false
}