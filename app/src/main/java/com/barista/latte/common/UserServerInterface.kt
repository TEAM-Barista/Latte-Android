package com.barista.latte.common

import com.barista.latte.auth.model.UserRequestObject
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/*
* Created by Juhyang on 2021/10/30
*/

interface UserServerInterface {
    @POST("api/users/signup")
    suspend fun signUp(@Body userRequestObject: UserRequestObject) : Response<Void>
}
