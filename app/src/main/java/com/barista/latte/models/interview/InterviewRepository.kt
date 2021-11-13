package com.barista.latte.models.interview

import com.barista.latte.common.RetrofitObject
import com.barista.latte.models.auth.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

/*
* Created by Juhyang on 2021/11/09
*/

@Singleton
class InterviewRepository @Inject constructor(private val userRepository: UserRepository) {
    private val serverInterface = RetrofitObject.getInterviewServerInterface()
    private val accessToken: String get() = userRepository.accessToken

    suspend fun getInterview(interviewId: Int) = serverInterface.getInterview(accessToken, interviewId)

    suspend fun getCarouselInterview() = serverInterface.getInterviewCarousel(accessToken)

    suspend fun setInterviewBookmark(interviewId: Int) = serverInterface.setInterviewBookmark(accessToken, interviewId)

    suspend fun setInterviewLike(interviewId: Int) = serverInterface.setInterviewLike(accessToken, interviewId)

    suspend fun getInterviewListRecent() = serverInterface.getInterviewListRecent(accessToken)

    suspend fun getInterviewListRecommend() = serverInterface.getInterviewListRecommend(accessToken)

    suspend fun requestSenior() = serverInterface.requestSenior(accessToken)
}
