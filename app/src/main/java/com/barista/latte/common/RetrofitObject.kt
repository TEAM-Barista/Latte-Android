package com.barista.latte.common

import com.barista.latte.models.auth.AuthServerInterface
import com.barista.latte.models.category.CategoryServerInterface
import com.barista.latte.models.interview.InterviewServerInterface
import com.barista.latte.post.models.PostServerInterface
import com.barista.latte.notification.NotificationServerInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
* Created by Juhyang on 2021/10/30
*/

object RetrofitObject {
    private const val baseUrl = "http://13.209.84.248:8080"

    val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                    OkHttpClient.Builder().addInterceptor(
                            HttpLoggingInterceptor().apply { this.level = HttpLoggingInterceptor.Level.BODY }
                    ).build())
            .build()

    fun getAuthServerInterface(): AuthServerInterface {
        return retrofit.create(AuthServerInterface::class.java)
    }

    fun getUserServerInterface(): UserServerInterface {
        return retrofit.create(UserServerInterface::class.java)
    }

    fun getInterviewServerInterface(): InterviewServerInterface {
        return retrofit.create(InterviewServerInterface::class.java)
    }

    fun getPostServerInterface(): PostServerInterface {
        return retrofit.create(PostServerInterface::class.java)
    }

    fun getNotificationServerInterface() : NotificationServerInterface {
        return retrofit.create(NotificationServerInterface::class.java)
    }

    fun getCategoryServerInterface(): CategoryServerInterface {
        return retrofit.create(CategoryServerInterface::class.java)
    }
}
