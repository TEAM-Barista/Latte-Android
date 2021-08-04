package com.barista.latte.models

/**

 * Created by juhyang on 2021/08/01.

 */
data class Post(val title : String, val contents : String, val writer : String, var bookmarkCount : Int, var commentCount : Int, var imageUrl : String?) {
    fun getBookmarkCount() : String {
        return if (bookmarkCount > 999) {
            "999+"
        } else {
            bookmarkCount.toString()
        }
    }

    fun getCommentCount() : String {
        return if (commentCount > 999) {
            "999+"
        } else {
            commentCount.toString()
        }
    }
}
