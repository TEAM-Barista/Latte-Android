package com.barista.latte.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**

 * Created by juhyang on 2021/08/01.

 */

@Parcelize
data class Post(val title : String, val contents : String, val writer : String, var bookmarkCount : Int, var commentCount : Int, var imageUrl : String?) : Parcelable {
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
}
