package com.barista.latte.models.post

import com.barista.latte.common.RetrofitObject
import com.barista.latte.models.auth.UserRepository
import com.barista.latte.models.post.request.PostRequestBody
import javax.inject.Inject

/*
* Created by Juhyang on 2021/11/10
*/

class PostRepository @Inject constructor(private val userRepository: UserRepository) {

    private val serverInterface = RetrofitObject.getPostServerInterface()
    private val accessToken: String get() = userRepository.accessToken

    suspend fun deletePost(postId: Int) = serverInterface.deletePost(accessToken, postId)

    suspend fun deleteReply(replyId: Int) = serverInterface.deleteReply(accessToken, replyId)

    suspend fun getPost(postId: Int) = serverInterface.getPost(accessToken, postId)

    suspend fun savePost(postRequestBody: PostRequestBody) = serverInterface.savePost(accessToken, postRequestBody)

    suspend fun postBookmark(postId: Int) = serverInterface.postBookmark(accessToken, postId)

    suspend fun getPostList() = serverInterface.getPostList(accessToken)

    suspend fun getPostListPopular() = serverInterface.getPostListPopular(accessToken)

    suspend fun getPostListRecent() = serverInterface.getPostListRecent(accessToken)

    suspend fun postQna(postRequestBody: PostRequestBody) = serverInterface.postQna(accessToken, postRequestBody)

    suspend fun writeReply(postContent: String, postId: Int) = serverInterface.writeReply(accessToken, postContent, postId)

    suspend fun likeReply(replyId: Int) = serverInterface.likeReply(accessToken, replyId)

    suspend fun getReplyListOld(postId: Int) = serverInterface.getReplyListOld(accessToken, postId)

    suspend fun getReplyListRecent(postId: Int) = serverInterface.getReplyListOld(accessToken, postId)

    suspend fun updatePost(postId: Int, postRequestBody: PostRequestBody) = serverInterface.updatePost(accessToken, postId, postRequestBody)

    suspend fun updateReply(replyId: Int, replyContent: String) = serverInterface.updateReply(accessToken, replyId, replyContent)
}
