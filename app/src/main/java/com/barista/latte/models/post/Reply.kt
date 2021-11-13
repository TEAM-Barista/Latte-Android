package com.barista.latte.models.post

/*
* Created by Juhyang on 2021/11/14
*/

data class Reply(
        val createDate: String,
        val image: String,
        val isLiked: Int,
        val postId: Int,
        val replyContent: String,
        val replyId: Int,
        val replyLikeCount: Int,
        val userId: Int,
        val userName: String
)
