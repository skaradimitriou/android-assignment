package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

data class MarketCaption(
    val betCaptions: Any?,
    val betTypeSysname: String?,
    val marketCaption: String?
) : LocalModel {
    override fun equalsContent(data: LocalModel): Boolean = false
}