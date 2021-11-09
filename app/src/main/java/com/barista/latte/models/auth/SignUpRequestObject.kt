package com.barista.latte.models.auth

import com.google.gson.annotations.SerializedName

/*
* Created by Juhyang on 2021/10/30
*/

class SignUpRequestObject(
        @SerializedName("nickName")
        val nickName: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("password")
        val password: String
)
