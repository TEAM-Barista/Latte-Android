package com.barista.latte.post

import com.barista.latte.models.post.Post
import javax.inject.Inject

/*
* Created by Juhyang on 2021/10/11
*/

class PostRepository @Inject constructor() {
    fun getPost(postId: Long): Post {
        return Post()
    }
}
