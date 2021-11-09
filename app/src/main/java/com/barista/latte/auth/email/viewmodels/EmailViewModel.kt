package com.barista.latte.auth.email.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barista.latte.models.auth.UserRepository
import com.barista.latte.models.auth.LoginStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/*
* Created by Juhyang on 2021/10/30
*/

@HiltViewModel
class EmailViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    private val _loginStatus: MutableLiveData<LoginStatus> = MutableLiveData()
    val loginStatus: LiveData<LoginStatus> get() = _loginStatus

    val email: MutableLiveData<String> = MutableLiveData()

    val password: MutableLiveData<String> = MutableLiveData()

    fun signIn() {
        Timber.d("#juhyang SignIn")
        val email = email.value ?: return
        val password = password.value ?: return
        viewModelScope.launch {
            _loginStatus.value = userRepository.signInByEmail(email, password)
        }
    }
}
