package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

class UpdatedHeadlines : ArrayList<UpdatedHeadlinesItem>() ,LocalModel {
    override fun equalsContent(data: LocalModel): Boolean = false
}