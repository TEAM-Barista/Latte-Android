package com.barista.latte.home.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barista.latte.models.auth.UserRepository
import com.barista.latte.models.interview.Interview
import com.barista.latte.models.interview.InterviewRepository
import com.barista.latte.post.models.Post
import com.barista.latte.post.models.PostRepository
import com.barista.latte.post.models.TabStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val userRepository: UserRepository, private val interviewRepository: InterviewRepository, private val postRepository: PostRepository) : ViewModel() {

    private val _currentWeekInterview: MutableLiveData<Interview> = MutableLiveData<Interview>()
    val currentWeekInterview: LiveData<Interview>
        get() {
            return _currentWeekInterview
        }

    private val _tabStatus: MutableLiveData<TabStatus> = MutableLiveData()

    private val _postList: MutableLiveData<List<Post>> = MutableLiveData()
    val postList: LiveData<List<Post>> get() = _postList

    fun loadData() {
        getCarouselInterview()

        viewModelScope.launch {
            _postList.value = postRepository.getPostList()
        }

        _tabStatus.value = TabStatus.QUESTION
    }

    private fun getCarouselInterview() {
        viewModelScope.launch {
            val response = interviewRepository.getCarouselInterview()
            if (response.isSuccessful) {
                _currentWeekInterview.value = response.body()
            } else {
                if (response.code() == 401) {
                    userRepository.refreshTokenWithServer {
                        getCarouselInterview()
                    }
                }
            }
        }
    }

    fun setTabStatus(tabStatus: TabStatus) {
        _tabStatus.value = tabStatus
        // TODO : ??
    }

    fun requestInterviewAction() {
        viewModelScope.launch {
            interviewRepository.requestSenior()
        }
        // TODO : Request Interview Action
    }
}
