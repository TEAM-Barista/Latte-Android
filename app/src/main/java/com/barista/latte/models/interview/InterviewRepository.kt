package com.barista.latte.models.interview

import android.content.Context
import com.barista.latte.common.RetrofitObject
import com.barista.latte.models.auth.UserRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/*
* Created by Juhyang on 2021/11/09
*/

@Singleton
class InterviewRepository @Inject constructor(@ApplicationContext val context: Context, val userRepository: UserRepository) {
    suspend fun getCarouselInterview() : Interview? {
        val accessToken = userRepository.accessToken
        val interviewResponse = RetrofitObject.getInterviewServerInterface().getInterviewCarousel(accessToken)
        Timber.d("#juhyang interviewR : ${interviewResponse.code()}")
        when (interviewResponse.code()) {
            200 -> {
                return interviewResponse.body()
            }
            401 -> {
                userRepository.refreshTokenWithServer {
                    CoroutineScope(Dispatchers.IO).launch {
                        getCarouselInterview()
                    }
                }
            }
        }
        return null
    }

    fun getInterviewById() {

    }
}
