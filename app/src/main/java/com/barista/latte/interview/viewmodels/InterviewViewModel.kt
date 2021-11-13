package com.barista.latte.interview.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barista.latte.models.auth.UserRepository
import com.barista.latte.models.interview.Interview
import com.barista.latte.models.interview.InterviewRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InterviewViewModel @Inject constructor(private val interviewRepository: InterviewRepository, private val userRepository: UserRepository) : ViewModel() {
    private val _newInterviewList: MutableLiveData<List<Interview>> = MutableLiveData()
    val newInterviewList: LiveData<List<Interview>> get() = _newInterviewList

    private val _priorInterviewList: MutableLiveData<List<Interview>> = MutableLiveData()
    val priorInterviewList: LiveData<List<Interview>> get() = _priorInterviewList


    fun loadData() {
        getNewInterviewList()
//        getPriorInterviewList() // TODO : 나중에 API 변경되면 수정 필요
    }

    fun getNewInterviewList() {
        viewModelScope.launch {
            val response = interviewRepository.getInterviewListRecent()
            if (response.isSuccessful) {
                val interviewList = response.body() ?: return@launch
                if (interviewList.isNotEmpty()) {
                    val newInterviewList: MutableList<Interview> = mutableListOf(interviewList[0])
                    _newInterviewList.value = newInterviewList
                }

                if (interviewList.size > 1) {
                    val priorInterviewList: MutableList<Interview> = mutableListOf()
                    priorInterviewList.addAll(interviewList.subList(1, interviewList.size))

                    _priorInterviewList.value = priorInterviewList
                }
            } else {
                if (response.code() == 401) {
                    userRepository.refreshTokenWithServer {
                        getNewInterviewList()
                    }
                }
            }
        }
    }

    fun getPriorInterviewList() {}
}
