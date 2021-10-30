package com.barista.latte.auth.signin.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.barista.latte.auth.email.view.EmailActivity
import com.barista.latte.auth.signup.view.SignUpActivity
import com.barista.latte.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignInBinding

    private val loginActivityResultLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
        val intent = activityResult.data ?: return@registerForActivityResult
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)

        aboutView()
        setContentView(binding.root)
    }

    private fun aboutView() {
        binding.email.setOnClickListener {
            loginActivityResultLauncher.launch(Intent(this, EmailActivity::class.java))
        }

        binding.signUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
