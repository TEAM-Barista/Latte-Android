package com.barista.latte.common

import com.barista.latte.auth.AuthServerInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
* Created by Juhyang on 2021/10/30
*/

object RetrofitObject {
    private fun getRetrofit(): Retrofit {
        val baseUrl = "http://13.209.84.248:8080"
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun getAuthServerInterface() : AuthServerInterface {
        return getRetrofit().create(AuthServerInterface::class.java)
    }
}
