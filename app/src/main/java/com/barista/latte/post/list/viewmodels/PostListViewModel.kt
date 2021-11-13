package com.barista.latte.post.list.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.barista.latte.models.post.Post

class PostListViewModel : ViewModel() {

    private val _postList : MutableLiveData<List<Post>> = MutableLiveData()
    val postList : LiveData<List<Post>>
        get() {
            return _postList
        }

    fun loadData() {
        val postList = ArrayList<Post>()
        _postList.value = postList
    }
}
