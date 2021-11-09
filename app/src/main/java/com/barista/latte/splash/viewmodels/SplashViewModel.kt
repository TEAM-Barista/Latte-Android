package com.barista.latte.splash.viewmodels

import androidx.lifecycle.ViewModel
import com.barista.latte.models.auth.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/*
* Created by Juhyang on 2021/10/30
*/

@HiltViewModel
class SplashViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    val accessToken : String get() = userRepository.accessToken

    val refreshToken : String get() = userRepository.refreshToken
}
