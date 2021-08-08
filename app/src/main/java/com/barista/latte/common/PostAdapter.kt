package com.barista.latte.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.barista.latte.databinding.ItemPostBinding
import com.barista.latte.models.Post
import timber.log.Timber

/**

 * Created by juhyang on 2021/08/01.

 */
class PostAdapter(val onViewClick: (post: Post) -> Unit) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private val postList: ArrayList<Post> = ArrayList()

    fun setPostList(postList: List<Post>) {
        this.postList.clear()
        this.postList.addAll(postList)
        notifyDataSetChanged()

        Timber.d("#juhyang notify : ${this.postList}")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        holder.bindView(postList[position])
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    inner class ViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(post: Post) {
            binding.post = post
            binding.root.setOnClickListener {
                onViewClick(post)
            }
        }
    }
}
