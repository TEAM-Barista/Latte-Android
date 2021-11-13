package com.barista.latte.models.auth.request

import com.google.gson.annotations.SerializedName

/*
* Created by Juhyang on 2021/10/30
*/

class SignInRequestBody(
        @SerializedName("email")
        val email: String,
        @SerializedName("password")
        val password: String
)
