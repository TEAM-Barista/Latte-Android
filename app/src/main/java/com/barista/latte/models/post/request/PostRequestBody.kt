package com.barista.latte.models.post.request

/*
* Created by Juhyang on 2021/11/14
*/

data class PostRequestBody (val postCode : String, val postContent : String, val postTags : List<Int>, val postTitle : String)
