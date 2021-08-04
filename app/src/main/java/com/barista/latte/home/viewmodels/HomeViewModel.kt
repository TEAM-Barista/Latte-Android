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

    fun requestInterviewAction() {
        Timber.d("#juhyang requestInterviewAction")
    }
}
