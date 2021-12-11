package com.barista.latte.notification

import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.POST

/*
* Created by Juhyang on 2021/12/09
*/

interface NotificationServerInterface {
    @POST("api/push")
    suspend fun sendToken(@Header("X-AUTH-TOKEN") accessToken: String, @Header("X-PUSH-TOKEN") fcmToken : String) : Response<Void>
}
