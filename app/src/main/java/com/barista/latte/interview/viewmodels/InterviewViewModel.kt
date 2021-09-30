package com.barista.latte.interview.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.barista.latte.models.Interview

class InterviewViewModel : ViewModel() {
    private val _newInterviewList : MutableLiveData<List<Interview>> = MutableLiveData()
    val newInterviewList : LiveData<List<Interview>> get() = _newInterviewList

    private val _priorInterviewList : MutableLiveData<List<Interview>> = MutableLiveData()
    val priorInterviewList : LiveData<List<Interview>> get() = _priorInterviewList


    fun loadData() {
        val newInterviewList = ArrayList<Interview>()
        for (i in 0 until 3) {
            newInterviewList.add(Interview(i.toLong(), "Title", "Contents"))
        }

        _newInterviewList.value = newInterviewList

        val priorInterviewList = ArrayList<Interview>()
        for (i in 0 until 3) {
            priorInterviewList.add(Interview(i.toLong(),"Title", "Contents"))
        }
        _priorInterviewList.value = priorInterviewList
    }
}
