package com.barista.latte.post.list.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.barista.latte.databinding.ItemPostBinding
import com.barista.latte.models.post.Post

/**

 * Created by juhyang on 2021/08/01.

 */
class PostListAdapter(val onViewClick: (post: Post) -> Unit) : ListAdapter<Post, PostListAdapter.ViewHolder>(PostDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding = ItemPostBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }

    inner class ViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(post: Post) {
            binding.post = post
            binding.root.setOnClickListener {
                onViewClick(post)
            }
        }
    }

    object PostDiffCallback : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean { // 고유 값을 비교하는것이 좋다.
            return oldItem.postId == newItem.postId
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean { // 객체가 같은지 비교하는 것이 좋다.
            return oldItem == newItem
        }
    }
}
