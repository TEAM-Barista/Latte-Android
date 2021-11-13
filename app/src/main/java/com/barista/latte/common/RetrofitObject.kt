package com.barista.latte.common

import com.barista.latte.models.auth.AuthServerInterface
import com.barista.latte.models.category.CategoryServerInterface
import com.barista.latte.models.interview.InterviewServerInterface
import com.barista.latte.models.post.PostServerInterface
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

    fun getAuthServerInterface(): AuthServerInterface {
        return getRetrofit().create(AuthServerInterface::class.java)
    }

    fun getUserServerInterface(): UserServerInterface {
        return getRetrofit().create(UserServerInterface::class.java)
    }

    fun getInterviewServerInterface(): InterviewServerInterface {
        return getRetrofit().create(InterviewServerInterface::class.java)
    }

    fun getPostServerInterface(): PostServerInterface {
        return getRetrofit().create(PostServerInterface::class.java)
    }

    fun getCategoryServerInterface(): CategoryServerInterface {
        return getRetrofit().create(CategoryServerInterface::class.java)
    }
}
