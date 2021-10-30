package com.barista.latte.auth.email.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barista.latte.auth.UserRepository
import com.barista.latte.auth.model.LoginStatus
import com.barista.latte.auth.model.SignInRequestObject
import com.barista.latte.auth.model.SignUpRequestObject
import com.barista.latte.auth.model.TokenObject
import com.barista.latte.common.RetrofitObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/*
* Created by Juhyang on 2021/10/30
*/

@HiltViewModel
class EmailViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    private val _loginStatus : MutableLiveData<LoginStatus> = MutableLiveData()
    val loginStatus : LiveData<LoginStatus> get() = _loginStatus

    fun signIn(email : String, password : String) {
        viewModelScope.launch {
            val loginResponse = RetrofitObject.getAuthServerInterface().signIn(SignInRequestObject(email, password))
            if (loginResponse.isSuccessful) {

                if (loginResponse.code() == 200) {
                    val tokenObject : TokenObject = loginResponse.body()!!

                    userRepository.writeAccessTokenToDataStore(tokenObject.accessToken)
                    userRepository.writeRefreshTokenToDataStore(tokenObject.refreshToken)

                    _loginStatus.value = LoginStatus.SUCCESS
                }
            } else {
            }
        }
    }
}
