package com.stathis.novibetassignment.models

import com.google.gson.annotations.SerializedName
import com.stathis.novibetassignment.abstraction.LocalModel

data class UpdatedGamesItem(

    @SerializedName("betViews")
    val betviews : List<GameBetviewItem>

) : LocalModel{
    override fun equalsContent(data: LocalModel): Boolean = false
}
