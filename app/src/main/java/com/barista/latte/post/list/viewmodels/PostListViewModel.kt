package com.barista.latte.post.list.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.barista.latte.models.Post

class PostListViewModel : ViewModel() {

    private val _postList : MutableLiveData<List<Post>> = MutableLiveData()
    val postList : LiveData<List<Post>>
        get() {
            return _postList
        }

    fun loadData() {
        val postList = ArrayList<Post>()
        for (i in 0 until 10) {
            postList.add(Post(i.toLong(), "Headline-1line", "Our public platform serves 100 million people every month, making it one of the 50 most ", "Minky", 1000, 1000, null))
        }
        _postList.value = postList
    }
}
