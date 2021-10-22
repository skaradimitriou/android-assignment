package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

data class UpdatedHeadlines(val results : ArrayList<UpdatedHeadlinesItem>) : LocalModel {
    override fun equalsContent(data: LocalModel): Boolean = false
}