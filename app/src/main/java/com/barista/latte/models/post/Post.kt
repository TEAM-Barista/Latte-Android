package com.barista.latte.models.post

/**

 * Created by juhyang on 2021/08/01.

 */
data class Post(
        val bookmarkCount: Int = 0,
        val commentCount: Int = 0,
        val isBookmarked: Boolean = false,
        val postContent: String = "",
        val postId: Int = -1,
        val postTitle: String = "",
        val replyCount: Int = 0,
        val tagsIds: List<Int> = listOf(),
        val tags: List<String> = listOf(),
        val userId: Int = 0,
        val userName: String = ""
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
