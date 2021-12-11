package com.barista.latte.notification

import com.barista.latte.common.RetrofitObject
import com.barista.latte.models.auth.UserRepository
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/*
* Created by Juhyang on 2021/12/09
*/

@AndroidEntryPoint
class FCMService : FirebaseMessagingService() {
    @Inject
    lateinit var userRepository : UserRepository


    override fun onNewToken(token: String) {
        Timber.d("#juhyang newtoken : ${token}")

        sendTokenToServer(token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        Timber.d("#juhyang message : ${message}")
        Timber.d("#juhyang message.data : ${message.data}")
        val notification = message.notification ?: return
        Timber.d("#juhyang notification : ${notification.title}")
        Timber.d("#juhyang notification : ${notification.body}")
    }


    fun sendTokenToServer(newToken: String) {
        val retrofit = RetrofitObject.getNotificationServerInterface()

        CoroutineScope(Dispatchers.IO).launch {
            val sendTokenResponse = retrofit.sendToken(userRepository.accessToken, newToken)

            Timber.d("#juhyang sendTokenResponse : ${sendTokenResponse.code()}")

            if (sendTokenResponse.code() == 401) {
                userRepository.refreshTokenWithServer {
                    sendTokenToServer(newToken)
                }
            }
        }
    }
}
