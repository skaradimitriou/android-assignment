package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

data class LoginData(val userName : String, val password : String) : LocalModel{
    override fun equalsContent(data: LocalModel): Boolean = false
}
