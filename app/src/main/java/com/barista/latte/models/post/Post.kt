package com.barista.latte.models.post

/**

 * Created by juhyang on 2021/08/01.

 */
data class Post(val id: Long, val title: String, val contents: String, val writer: String, var bookmarkCount: Int, var commentCount: Int, var imageUrl: String?) {
    fun getBookmarkCountString() : String {
        return if (bookmarkCount > 999) {
            "999+"
        } else {
            bookmarkCount.toString()
        }
    }

    fun getCommentCountString() : String {
        return if (commentCount > 999) {
            "999+"
        } else {
            commentCount.toString()
        }
    }

    fun getImageUrlString() : String {
        return imageUrl ?: ""
    }

    fun getDateString() : String {
        return "7 hours ago"
    }
}
