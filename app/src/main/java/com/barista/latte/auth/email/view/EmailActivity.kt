package com.barista.latte.auth.email.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.barista.latte.auth.email.viewmodels.EmailViewModel
import com.barista.latte.auth.model.LoginStatus
import com.barista.latte.auth.signup.view.SignUpActivity
import com.barista.latte.databinding.ActivityEmailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EmailActivity : AppCompatActivity() {

    lateinit var binding : ActivityEmailBinding
    val viewModel : EmailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        aboutView()
        setObserver()

        setContentView(binding.root)
    }

    private fun aboutView() {
        binding.signUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setObserver() {
        viewModel.loginStatus.observe(this) { loginStatus ->
            if (loginStatus == LoginStatus.SUCCESS) {
                val intent = Intent()
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}
