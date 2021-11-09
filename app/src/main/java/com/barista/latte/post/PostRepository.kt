package com.barista.latte.post

import com.barista.latte.models.post.Post
import javax.inject.Inject

/*
* Created by Juhyang on 2021/10/11
*/

class PostRepository @Inject constructor() {
    fun getPost(postId: Long): Post {
        return Post(postId, "Headline-1line", "Our public platform serves 100 million people every month, making it one of the 50 most ", "Minky", 1000, 1000, null)
    }
}
