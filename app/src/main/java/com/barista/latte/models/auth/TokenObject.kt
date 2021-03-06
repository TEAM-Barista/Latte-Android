package com.barista.latte.models.auth

import com.google.gson.annotations.SerializedName

/*
* Created by Juhyang on 2021/10/30
*/

data class TokenObject (
        @SerializedName("accessToken")
        val accessToken : String,
        @SerializedName("refreshToken")
        val refreshToken : String
)
