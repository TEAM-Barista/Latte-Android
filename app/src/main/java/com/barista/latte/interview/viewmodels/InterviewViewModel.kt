package com.barista.latte.interview.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.barista.latte.models.interview.Interview
import com.barista.latte.models.interview.InterviewRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InterviewViewModel @Inject constructor(val interviewRepository : InterviewRepository) : ViewModel() {
    private val _newInterviewList : MutableLiveData<List<Interview>> = MutableLiveData()
    val newInterviewList : LiveData<List<Interview>> get() = _newInterviewList

    private val _priorInterviewList : MutableLiveData<List<Interview>> = MutableLiveData()
    val priorInterviewList : LiveData<List<Interview>> get() = _priorInterviewList


    fun loadData() {
        getNewInterviewList()
        getPriorInterviewList()
        val newInterviewList = ArrayList<Interview>()

        _newInterviewList.value = newInterviewList

        val priorInterviewList = ArrayList<Interview>()

        _priorInterviewList.value = priorInterviewList
    }

    fun getNewInterviewList() {}
    fun getPriorInterviewList() {}
}
