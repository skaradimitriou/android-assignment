package com.stathis.novibetassignment.models

import com.google.gson.annotations.SerializedName
import com.stathis.novibetassignment.abstraction.LocalModel

data class UpdatedGamesItem(

    @SerializedName("betViews")
    val betviews : List<GameBetviewItem>,
    val caption : String,
    val marketViewType : String,
    val marketViewKey : String,
    val modelType : String,
    val hasHighlights : Boolean,
    val totalCount : Int

) : LocalModel{
    override fun equalsContent(data: LocalModel): Boolean = false
}
