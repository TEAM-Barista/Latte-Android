package com.barista.latte.mypage.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.barista.latte.models.HashTag
import com.barista.latte.models.User
import timber.log.Timber

class MyPageViewModel : ViewModel() {
    private val _user : MutableLiveData<User> = MutableLiveData<User>()
    val user : LiveData<User> get() = _user // LiveData.setValue -> protected 라서 접근제어자에 걸린다. 따라서 _user 를 통해서 MutableLiveData

    private val _notificationCount : MutableLiveData<Int> = MutableLiveData<Int>(999)
    val notificationCount : LiveData<Int> get() = _notificationCount

    private val _bookmarkCount : MutableLiveData<Int> = MutableLiveData(999)
    val bookmarkCount : LiveData<Int> get() = _bookmarkCount

    private val _questionCount : MutableLiveData<Int> = MutableLiveData(999)
    val questionCount : LiveData<Int> get() = _questionCount

    private val _answerCount : MutableLiveData<Int> = MutableLiveData(999)
    val answerCount : LiveData<Int> get() = _answerCount

    fun loadData() {
        _user.value = User("Silverash", "", "Silverash@kakao.co.kr", listOf(HashTag("Android"), HashTag("Kotlin")))
    }
}
