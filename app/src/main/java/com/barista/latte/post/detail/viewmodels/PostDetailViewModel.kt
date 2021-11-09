package com.barista.latte.post.detail.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.barista.latte.models.post.Post
import com.barista.latte.post.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/*
* Created by Juhyang on 2021/10/04
*/

@HiltViewModel
class PostDetailViewModel @Inject constructor(private val postRepository : PostRepository) : ViewModel() {

    private val _post : MutableLiveData<Post> = MutableLiveData()
    val post : LiveData<Post> get() = _post

    fun loadData(postId : Long) {
        _post.value = postRepository.getPost(postId)
    }
}
