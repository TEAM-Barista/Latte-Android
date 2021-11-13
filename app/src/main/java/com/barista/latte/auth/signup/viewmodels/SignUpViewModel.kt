package com.barista.latte.auth.signup.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barista.latte.models.auth.UserRepository
import com.barista.latte.models.auth.LoginStatus
import com.barista.latte.models.auth.request.SignUpRequestBody
import com.barista.latte.common.RetrofitObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/*
* Created by Juhyang on 2021/10/30
*/

@HiltViewModel
class SignUpViewModel @Inject constructor(private val userRepository : UserRepository) : ViewModel() {

    private val _loading : MutableLiveData<Boolean> = MutableLiveData(false)
    val loading : LiveData<Boolean> get() = _loading

    private val _loginStatus : MutableLiveData<LoginStatus> = MutableLiveData()
    val loginStatus : LiveData<LoginStatus> get() = _loginStatus

    fun signUp(nickName: String, email: String, password: String) {
        val userRequestObject = SignUpRequestBody(nickName, email, password)

        viewModelScope.launch {
            val signUpResponse = RetrofitObject.getUserServerInterface().signUp(userRequestObject)
            withContext(Dispatchers.Main) {
                if (signUpResponse.isSuccessful) {
                    _loginStatus.value = LoginStatus.SUCCESS
                    // 1. 액티비티 종료. 토큰 발급 후 메인으로 이동 /
                    // 2. 액티비티 종료. 토큰 발급하지 않고 로그인 화면으로 이동
                } else {
                    // 유저에게 재시도 요청
                    _loginStatus.value = LoginStatus.FAIL
                }
            }
        }
    }
}
