package com.barista.latte.post.list.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barista.latte.models.auth.UserRepository
import com.barista.latte.models.post.Post
import com.barista.latte.models.post.PostRepository
import com.barista.latte.models.post.TabStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostListViewModel @Inject constructor(private val postRepository: PostRepository, private val userRepository: UserRepository) : ViewModel() {

    private val _postList: MutableLiveData<List<Post>> = MutableLiveData()
    val postList: LiveData<List<Post>> get() = _postList

    private val _tabStatus: MutableLiveData<TabStatus> = MutableLiveData()

    var questionList: List<Post>? = null
    var communityPostList: List<Post>? = null

    fun loadData() {
        val postList = ArrayList<Post>()
        _postList.value = postList

        if (_tabStatus.value == null) {
            _tabStatus.value = TabStatus.QUESTION
            setPostList(_tabStatus.value!!)
        }
    }

    fun setPostList(tabStatus: TabStatus) {
        _tabStatus.value = tabStatus
        when (tabStatus) {
            TabStatus.QUESTION -> {
                if (questionList == null) {
                    getQuestionList()
                } else {
                    _postList.value = questionList
                }
            }
            TabStatus.COMMUNITY -> {
                if (communityPostList == null) {
                    getCommunityList()
                } else {
                    _postList.value = communityPostList
                }
            }
        }
    }

    private fun getQuestionList() {
        viewModelScope.launch {
            val response = postRepository.getPostListRecent()
            if (response.isSuccessful) {
                questionList = response.body()
                _postList.value = questionList
            } else {
                if (response.code() == 401) {
                    userRepository.refreshTokenWithServer {
                        getQuestionList()
                    }
                }
            }
        }
    }

    private fun getCommunityList() {
        viewModelScope.launch {
            val response = postRepository.getPostListRecent()
            if (response.isSuccessful) {
                communityPostList = response.body()
                _postList.value = communityPostList
            } else {
                if (response.code() == 401) {
                    userRepository.refreshTokenWithServer {
                        getCommunityList()
                    }
                }
            }
        }
    }
}
