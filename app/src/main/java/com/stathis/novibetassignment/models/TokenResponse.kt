package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

data class TokenResponse(val access_token : String, val token_type : String) : LocalModel{
    override fun equalsContent(data: LocalModel): Boolean = false
}
