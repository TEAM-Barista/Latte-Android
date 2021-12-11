package com.barista.latte.post.models

import com.barista.latte.common.Pageable
import com.barista.latte.post.models.request.PostRequestBody
import com.barista.latte.post.models.request.ReadPostRequestBody
import retrofit2.Response
import retrofit2.http.*

/*
* Created by Juhyang on 2021/11/10
*/

interface PostServerInterface {

    @FormUrlEncoded
    @POST("api/v1/deletePost")
    suspend fun deletePost(@Header("X-AUTH-TOKEN") accessToken: String, @Field("postId") postId: Int): Response<Void>

    @POST("api/v1/deleteReply")
    suspend fun deleteReply(@Header("X-AUTH-TOKEN") accessToken: String, @Field("replyId") replyId: Int): Response<Void>

    @GET("api/v1/post/readPost")
    suspend fun getPost(@Header("X-AUTH-TOKEN") accessToken: String, @Body readPostRequestBody : ReadPostRequestBody): Response<Post>

    @POST("api/v1/post")
    suspend fun savePost(@Header("X-AUTH-TOKEN") accessToken: String, @Body postRequestBody: PostRequestBody): Response<Void>

    @FormUrlEncoded
    @POST("api/v1/postBookmark")
    suspend fun postBookmark(@Header("X-AUTH-TOKEN") accessToken: String, @Field("postId") postId: Int): Response<Void>

    @GET("api/v1/post/postList")
    suspend fun getPostList(@Header("X-AUTH-TOKEN") accessToken: String): Response<Pageable<List<Post>>>

    @GET("api/v1/postListPopular")
    suspend fun getPostListPopular(@Header("X-AUTH-TOKEN") accessToken: String): Response<List<Post>>

    @POST("api/v1/qna")
    suspend fun postQna(@Header("X-AUTH-TOKEN") accessToken: String, @Body postRequestBody: PostRequestBody): Response<Void>

    @FormUrlEncoded
    @POST("api/v1/reply")
    suspend fun writeReply(@Header("X-AUTH-TOKEN") accessToken: String, @Field("postContent") postContent: String, @Field("postId") postId: Int): Response<Void>

    @FormUrlEncoded
    @POST("api/v1/replyLike")
    suspend fun likeReply(@Header("X-AUTH-TOKEN") accessToken: String, @Field("replyId") replyId: Int): Response<Void>

    @GET("api/v1/replyListOld")
    suspend fun getReplyListOld(@Header("X-AUTH-TOKEN") accessToken: String, @Query("postId") postId: Int): Response<List<Reply>>

    @GET("api/v1/replyListRecent")
    suspend fun getReplyListRecent(@Header("X-AUTH-TOKEN") accessToken: String, @Query("postId") postId: Int): Response<List<Reply>>

    @PUT("api/v1/updatePost/{postId}")
    suspend fun updatePost(@Header("X-AUTH-TOKEN") accessToken: String, @Path("postId") postId: Int, @Body postRequestBody: PostRequestBody): Response<Void>

    @FormUrlEncoded
    @PUT("api/v1/updateReply")
    suspend fun updateReply(@Header("X-AUTH-TOKEN") accessToken: String, @Path("replyId") replyId: Int, @Field("replyContent") replyContent: String): Response<Void>
}
