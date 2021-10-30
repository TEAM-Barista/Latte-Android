package com.barista.latte.auth.email.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.barista.latte.R
import com.barista.latte.databinding.ActivityEmailBinding

class EmailActivity : AppCompatActivity() {

    lateinit var binding : ActivityEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    fun aboutView() {
        binding.signUp.setOnClickListener {

        }
    }
}
