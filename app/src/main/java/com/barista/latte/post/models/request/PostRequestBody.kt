package com.barista.latte.post.models.request

/*
* Created by Juhyang on 2021/11/14
*/

data class PostRequestBody (val postCode : String, val postContent : String, val postTags : List<Int>, val postTitle : String)
