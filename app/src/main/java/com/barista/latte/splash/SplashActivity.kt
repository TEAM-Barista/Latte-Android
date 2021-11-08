package com.barista.latte.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import com.barista.latte.MainActivity
import com.barista.latte.R
import com.barista.latte.auth.UserRepository
import com.barista.latte.auth.signin.view.SignInActivity
import com.barista.latte.splash.viewmodels.SplashViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var userRepository: UserRepository

    val viewModel : SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler(Looper.getMainLooper())
                .postDelayed({
                    val intent = if (viewModel.accessToken.isEmpty() && viewModel.refreshToken.isEmpty()) {
                        Intent(this, SignInActivity::class.java)
                    } else {
                        Intent(this, MainActivity::class.java)
                    }

                    startActivity(intent)
                    finish()
                }, 3000)
    }
}
