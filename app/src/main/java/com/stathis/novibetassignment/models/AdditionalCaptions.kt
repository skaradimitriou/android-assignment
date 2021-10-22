package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

data class AdditionalCaptions(
    val competitor1: String?,
    val competitor1ImageId: Int?,
    val competitor2: String?,
    val competitor2ImageId: Int?,
    val type: Int?
) : LocalModel {
    override fun equalsContent(data: LocalModel): Boolean = false
}