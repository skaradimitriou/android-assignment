package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

data class GameBetviewItem(
    val betViewKey :String,
    val modelType :String,
    val competitionContextCaption :String,
    val competitions :List<CompetitionItem>
) : LocalModel{
    override fun equalsContent(data: LocalModel): Boolean = false
}