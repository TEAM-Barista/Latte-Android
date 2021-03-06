package com.barista.latte.post.detail.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barista.latte.post.models.Post
import com.barista.latte.post.models.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
* Created by Juhyang on 2021/10/04
*/

@HiltViewModel
class PostDetailViewModel @Inject constructor(private val postRepository : PostRepository) : ViewModel() {

    private val _post : MutableLiveData<Post> = MutableLiveData()
    val post : LiveData<Post> get() = _post

    fun loadData(postId : Int) {
        viewModelScope.launch {
            val postResponse = postRepository.getPost(postId)
            if (postResponse.isSuccessful) {
                _post.value = postResponse.body()
            }
        }

    }
}
