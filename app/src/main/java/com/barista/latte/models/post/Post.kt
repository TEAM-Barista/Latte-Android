package com.barista.latte.models.post

/**

 * Created by juhyang on 2021/08/01.

 */
data class Post(
        val bookmarkCount : Int,
        val commentCount : Int,
        val isBookmarked : Boolean,
        val postContent : String,
        val postId : Int,
        val postTitle : String,
        val replyCount : Int,
        val tagsIds : List<Int>,
        val tags : List<String>,
        val userId : Int,
        val userName : String
) {
    fun getBookmarkCountString(): String {
        return if (bookmarkCount > 999) {
            "999+"
        } else {
            bookmarkCount.toString()
        }
    }

    fun getCommentCountString(): String {
        return if (commentCount > 999) {
            "999+"
        } else {
            commentCount.toString()
        }
    }

    fun getImageUrlString(): String {
//        return imageUrl ?: ""
        return ""
    }

    fun getDateString(): String {
        return "7 hours ago"
    }
}
