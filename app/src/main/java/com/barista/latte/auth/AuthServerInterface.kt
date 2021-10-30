package com.barista.latte.auth

import com.barista.latte.auth.model.SignInRequestObject
import com.barista.latte.auth.model.TokenObject
import com.barista.latte.auth.model.SignUpRequestObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/*
* Created by Juhyang on 2021/10/30
*/

interface AuthServerInterface {
    @POST("api/auth/refresh")
    suspend fun refreshToken(@Body tokenObject: TokenObject) : Response<TokenObject>

    @POST("api/auth/signin")
    suspend fun signIn(@Body signUp : SignInRequestObject) : Response<TokenObject>
}
