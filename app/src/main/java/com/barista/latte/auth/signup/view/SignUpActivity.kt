package com.barista.latte.auth.signup.view

import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat
import com.barista.latte.R
import com.barista.latte.auth.model.LoginStatus
import com.barista.latte.auth.signup.viewmodels.SignUpViewModel
import com.barista.latte.databinding.ActivitySignUpBinding
import com.barista.latte.databinding.CommonTextActionbarBinding
import com.barista.latte.views.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import java.util.regex.Pattern

@AndroidEntryPoint
class SignUpActivity : BaseActivity() {
    lateinit var binding: ActivitySignUpBinding
    val viewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        aboutView()
        setObserver()

        setContentView(binding.root)
    }

    override fun setActionBar() {
        val actionBar = supportActionBar ?: return

        actionBar.setDisplayShowCustomEnabled(true)
        actionBar.setDisplayShowTitleEnabled(false)
        actionBar.setDisplayHomeAsUpEnabled(false)

        val actionBarBinding = CommonTextActionbarBinding.inflate(LayoutInflater.from(this))

        actionBarBinding.title.text = getString(R.string.sign_up)

        val params = ActionBar.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        actionBar.setCustomView(actionBarBinding.root, params)
    }

    override fun loadData() {
    }

    private fun aboutView() {
        binding.signUp.setOnClickListener {
            val nickName = binding.nicknameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val confirmPassword = binding.passwordEditText.text.toString()

            if (validNickName(nickName) && validEmail(email) && validPassword(password, confirmPassword)) {
                viewModel.signUp(nickName, email, password)
            } else {
                Toast.makeText(this, "다시한번 확인 해 주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setObserver() {
        viewModel.loading.observe(this) { loading ->

        }

        viewModel.loginStatus.observe(this) { loginStatus ->
            when (loginStatus) {
                LoginStatus.SUCCESS -> {
                    finish()
                }
                LoginStatus.FAIL -> {
                    Toast.makeText(this, "다시한번 확인 해 주세요.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun validNickName(nickName : String) : Boolean {
        val result = nickName.isNotEmpty()

        if (result) {
            binding.nicknameEditText.backgroundTintList = getBackgroundTintList(R.color.latte_green)
        } else {
            binding.nicknameEditText.backgroundTintList = getBackgroundTintList(R.color.latte_red)
        }

        return result
    }

    private fun validEmail(email: String): Boolean {
        val pattern = Patterns.EMAIL_ADDRESS

        return if (pattern.matcher(email).matches()) {
            binding.emailEditText.backgroundTintList = getBackgroundTintList(R.color.latte_green)
            true
        } else {
            binding.emailEditText.backgroundTintList = getBackgroundTintList(R.color.latte_red)
            false
        }
    }

    private fun validPassword(password: String, confirmPassword : String): Boolean {
        var result = false
        var pwPattern = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-zA-Z]).{8,20}$"
        val matcher = Pattern.compile(pwPattern).matcher(password)
        if (matcher.matches()) {
            result = true
        }
        pwPattern = "(.)\\1\\1\\1"
        val matcher2 = Pattern.compile(pwPattern).matcher(password)
        if (matcher2.find()) {
            result = false
        }

        if (password.contains(" ")) {
            result = false
        }

        if (password != confirmPassword) {
            result = false
        }

        if (result) {
            binding.passwordEditText.backgroundTintList = getBackgroundTintList(R.color.latte_green)
            binding.confirmPasswordEditText.backgroundTintList = getBackgroundTintList(R.color.latte_green)
        } else {
            binding.passwordEditText.backgroundTintList = getBackgroundTintList(R.color.latte_red)
            binding.confirmPasswordEditText.backgroundTintList = getBackgroundTintList(R.color.latte_red)
        }

        return result
    }

    private fun getBackgroundTintList(colorId : Int) : ColorStateList {
        return ColorStateList.valueOf(ContextCompat.getColor(this, colorId))
    }
}
