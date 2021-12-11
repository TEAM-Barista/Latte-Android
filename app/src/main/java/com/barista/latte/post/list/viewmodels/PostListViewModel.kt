package com.barista.latte.post.list.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barista.latte.models.auth.UserRepository
import com.barista.latte.post.models.Post
import com.barista.latte.post.models.PostRepository
import com.barista.latte.post.models.TabStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostListViewModel @Inject constructor(private val postRepository: PostRepository, private val userRepository: UserRepository) : ViewModel() {

    private val _postList: MutableLiveData<List<Post>> = MutableLiveData()
    val postList: LiveData<List<Post>> get() = _postList

    private val _tabStatus: MutableLiveData<TabStatus> = MutableLiveData()

    fun loadData() {
        viewModelScope.launch {
            _postList.value = postRepository.getPostList()
        }
        _tabStatus.value = TabStatus.QUESTION
    }

    fun setTabStatus(tabStatus: TabStatus) {
        _tabStatus.value = tabStatus

        // TODO : ??
        when (tabStatus) {
            TabStatus.QUESTION -> {
//                _postList.value = questionList
            }
            TabStatus.COMMUNITY -> {
//                _postList.value = communityPostList
            }
        }
    }
}
