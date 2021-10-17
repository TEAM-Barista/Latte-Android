package com.barista.latte.auth.signin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.barista.latte.R
import com.barista.latte.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    lateinit var binding : ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}
