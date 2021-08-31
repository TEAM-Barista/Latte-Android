package com.barista.latte.mypage.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.barista.latte.models.HashTag
import com.barista.latte.models.User

class MyPageViewModel : ViewModel() {
    private val _user : MutableLiveData<User> = MutableLiveData<User>()
    val user : LiveData<User> get() = _user // LiveData.setValue -> protected 라서 접근제어자에 걸린다. 따라서 _user 를 통해서 MutableLiveData

    fun loadData() {
        _user.value = User("Silverash", "", "Silverash@kakao.co.kr", listOf(HashTag("Android"), HashTag("Kotlin")))
    }
}
