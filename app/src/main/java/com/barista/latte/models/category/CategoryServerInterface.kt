package com.barista.latte.models.category

import retrofit2.http.GET
import retrofit2.http.POST

/*
* Created by Juhyang on 2021/11/10
*/

interface CategoryServerInterface {
    @GET("api/categories")
    suspend fun getCategories()

    @POST("api/categories")
    suspend fun postCategories()
}
