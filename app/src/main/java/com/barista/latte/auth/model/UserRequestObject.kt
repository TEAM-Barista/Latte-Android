package com.barista.latte.auth.model

import com.google.gson.annotations.SerializedName

/*
* Created by Juhyang on 2021/10/30
*/

class UserRequestObject(
        @SerializedName("email")
        val email: String,
        @SerializedName("nickName")
        val nickName: String,
        @SerializedName("password")
        val password: String
)