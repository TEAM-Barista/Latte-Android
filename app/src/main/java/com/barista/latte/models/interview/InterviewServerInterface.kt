package com.barista.latte.models.interview

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

/*
* Created by Juhyang on 2021/11/09
*/

interface InterviewServerInterface {
    @GET("/api/v1/interview")
    suspend fun getInterview(@Header("X-AUTH-TOKEN") accessToken : String, @Query("interviewId") interviewId: Int, @Query("userId") userId: Int) : Response<List<Interview>>

    @GET("/api/v1/interview/carousel")
    suspend fun getInterviewCarousel(@Header("X-AUTH-TOKEN") accessToken : String): Response<Interview>

    @POST("/api/v1/interviewBookmark")
    suspend fun setInterviewBookmark(@Header("X-AUTH-TOKEN") accessToken : String)

    @POST("/api/v1/interviewLike")
    suspend fun setInterviewLike(@Header("X-AUTH-TOKEN") accessToken : String,)

    @GET("/api/v1/interviewListRecent")
    suspend fun getInterviewListRecent( // 뭔가 거어어어어어어어어어어어업나 많아서 물어봐야
            @Header("X-AUTH-TOKEN") accessToken : String,
            @Query("contentKeyword") contentKeyword : String? = null,
            @Query("dateAfter") dateAfter : String? = null,
            @Query("dateBefore") dateBefore : String? = null,
            @Query("interviewId") interviewId : Int? = null,
    )

    @GET("/api/v1/interviewListRecommend")
    suspend fun getInterviewListRecommend(@Header("X-AUTH-TOKEN") accessToken : String)

    @POST("/api/v1/seniorRequest") // 이건 왜 interview가 빠져있어요
    suspend fun requestSenior(@Header("X-AUTH-TOKEN") accessToken : String)
}
