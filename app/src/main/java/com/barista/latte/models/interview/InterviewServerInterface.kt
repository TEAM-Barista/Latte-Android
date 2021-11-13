package com.barista.latte.models.interview

import retrofit2.Response
import retrofit2.http.*

/*
* Created by Juhyang on 2021/11/09
*/

interface InterviewServerInterface {
    @GET("/api/v1/interview")
    suspend fun getInterview(@Header("X-AUTH-TOKEN") accessToken: String, @Query("interviewId") interviewId: Int): Response<Interview>

    @GET("/api/v1/interview/carousel")
    suspend fun getInterviewCarousel(@Header("X-AUTH-TOKEN") accessToken: String): Response<Interview>

    @FormUrlEncoded
    @POST("/api/v1/interviewBookmark")
    suspend fun setInterviewBookmark(@Header("X-AUTH-TOKEN") accessToken: String, @Field("interviewId") interviewId: Int): Response<Void>

    @POST("/api/v1/interviewLike")
    suspend fun setInterviewLike(@Header("X-AUTH-TOKEN") accessToken: String, @Field("interviewId") interviewId: Int): Response<Void>

    @GET("/api/v1/interviewListRecent")
    suspend fun getInterviewListRecent(@Header("X-AUTH-TOKEN") accessToken: String): Response<List<Interview>>

    @GET("/api/v1/interviewListRecommend")
    suspend fun getInterviewListRecommend(@Header("X-AUTH-TOKEN") accessToken: String): Response<List<Interview>>

    @POST("/api/v1/seniorRequest") // 이건 왜 interview가 빠져있어요
    suspend fun requestSenior(@Header("X-AUTH-TOKEN") accessToken: String): Response<Void>
}
