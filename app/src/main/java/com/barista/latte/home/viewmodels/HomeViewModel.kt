package com.barista.latte.home.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.barista.latte.models.Interview
import com.barista.latte.models.Post
import timber.log.Timber

class HomeViewModel : ViewModel() {

    private val _currentWeekInterview : MutableLiveData<Interview> = MutableLiveData<Interview>()
    val currentWeekInterview : LiveData<Interview>
        get() {
            return _currentWeekInterview
        }

    private val _postList : MutableLiveData<List<Post>> = MutableLiveData()
    val postList : LiveData<List<Post>>
        get() {
            return _postList
        }

    fun loadData() {
        _currentWeekInterview.value = Interview("3rd-year developer", "Our public platform servers 100 million people every month, making it one of the 50 most popular websites")

        val postList = ArrayList<Post>()
        for (i in 0 until 5) {
            postList.add(Post(i.toLong(),"Headline-1line", "Our public platform serves 100 million people every month, making it one of the 50 most ", "Minky", 1000, 1000, null))
        }
        _postList.value = postList
    }

    fun requestInterviewAction() {
        Timber.d("#juhyang requestInterviewAction")
    }
}
