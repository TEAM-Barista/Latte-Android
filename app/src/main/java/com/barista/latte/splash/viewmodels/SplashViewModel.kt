package com.barista.latte.splash.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.barista.latte.auth.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

/*
* Created by Juhyang on 2021/10/30
*/

@HiltViewModel
class SplashViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    val accessToken : String get() {
        return runBlocking(Dispatchers.IO) {
            userRepository.accessTokenFlow.first()
        }
    }

    val refreshToken : String get() {
        return runBlocking(Dispatchers.IO) {
            userRepository.refreshTokenFlow.first()
        }
    }
}
