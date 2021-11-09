package com.barista.latte.home.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barista.latte.models.interview.Interview
import com.barista.latte.models.post.Post
import com.barista.latte.models.auth.UserRepository
import com.barista.latte.models.interview.InterviewRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val userRepository: UserRepository, val interviewRepository: InterviewRepository) : ViewModel() {

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
        getCarouselInterview()
        val postList = ArrayList<Post>()
        for (i in 0 until 5) {
            postList.add(Post(i.toLong(),"Headline-1line", "Our public platform serves 100 million people every month, making it one of the 50 most ", "Minky", 1000, 1000, null))
        }
        _postList.value = postList
    }

    fun getCarouselInterview() {
        viewModelScope.launch {
            val interview = interviewRepository.getCarouselInterview() ?: return@launch
            Timber.d("#juhyang interview : ${interview}")
            withContext(Dispatchers.Main) {
                _currentWeekInterview.value = interview
            }
        }
    }

    fun requestInterviewAction() {
        // TODO : Request Interview Action
    }
}
