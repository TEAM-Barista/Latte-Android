package com.barista.latte.activities.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.barista.latte.R
import com.barista.latte.MainActivity
import com.barista.latte.auth.signin.view.SignInActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper())
            .postDelayed({
                startActivity(Intent(this, SignInActivity::class.java))
                finish()
            }, 3000)
    }
}
