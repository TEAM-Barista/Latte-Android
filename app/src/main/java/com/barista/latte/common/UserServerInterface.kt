package com.barista.latte.common

import com.barista.latte.models.auth.request.SignUpRequestBody
import retrofit2.Response
import retrofit2.http.*

/*
* Created by Juhyang on 2021/10/30
*/

interface UserServerInterface {
    @GET("api/users/categories")
    suspend fun getCategories()

    @PATCH("api/users/categories")
    suspend fun setUserCategories()

    @DELETE("api/users/categories/{id}")
    suspend fun deleteUserCategory()

    @PATCH("api/users/categories/{id}")
    suspend fun setUserCategory()

    @PATCH("api/users/notify")
    suspend fun setAccessNotify()

    @PATCH("api/users/profile")
    suspend fun setProfileImage()

    @POST("api/users/signup")
    suspend fun signUp(@Body signUpRequestBody: SignUpRequestBody) : Response<Void>
}
