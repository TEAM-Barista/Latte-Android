package com.barista.latte.interview.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.barista.latte.databinding.ItemNewInterviewBinding
import com.barista.latte.databinding.ItemPriorInterviewBinding
import com.barista.latte.models.Interview

/*
* Created by Juhyang on 2021/09/04
*/

class PriorInterviewAdapter : ListAdapter<Interview, PriorInterviewAdapter.ViewHolder>(InterviewDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPriorInterviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    inner class ViewHolder(val binding : ItemPriorInterviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(interview : Interview) {

        }
    }
}
