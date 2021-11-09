package com.barista.latte.models.interview

import com.google.gson.annotations.SerializedName

/**

 * Created by juhyang on 2021/08/01.

 */
data class Interview(
        @SerializedName("bookmarkCount")
        val bookmarkCount : Int,
        @SerializedName("createdDate")
        val createdDate : String,
        @SerializedName("interviewContent")
        val contents : String,
        @SerializedName("interviewTitle")
        val title : String,
        @SerializedName("isBookmarked")
        val isBookmarked : Int,
        @SerializedName("likeCount")
        val likeCount : Int,
        @SerializedName("tagIds")
        val tagIdList : List<Int>,
        @SerializedName("tags")
        val tagStringList : List<String>,
        @SerializedName("userId")
        val userId : Int,
        @SerializedName("userName")
        val userName : String,
        @SerializedName("interviewId")
        val interviewId : Int
)
