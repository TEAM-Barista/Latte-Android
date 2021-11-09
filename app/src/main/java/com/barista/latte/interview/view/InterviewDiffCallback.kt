package com.barista.latte.interview.view

import androidx.recyclerview.widget.DiffUtil
import com.barista.latte.models.interview.Interview

/*
* Created by Juhyang on 2021/09/04
*/

object InterviewDiffCallback : DiffUtil.ItemCallback<Interview>() {
    override fun areItemsTheSame(oldItem: Interview, newItem: Interview): Boolean { // 고유 값을 비교하는것이 좋다.
        return oldItem.interviewId == newItem.interviewId
    }

    override fun areContentsTheSame(oldItem: Interview, newItem: Interview): Boolean { // 객체가 같은지 비교하는 것이 좋다.
        return oldItem == newItem
    }
}
