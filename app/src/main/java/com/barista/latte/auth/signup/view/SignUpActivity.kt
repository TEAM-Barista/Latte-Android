package com.barista.latte.auth.signup.view

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBar
import com.barista.latte.R
import com.barista.latte.databinding.ActivitySignUpBinding
import com.barista.latte.databinding.CommonTextActionbarBinding
import com.barista.latte.views.BaseActivity

class SignUpActivity : BaseActivity() {
    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)

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
}
