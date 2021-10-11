package com.barista.latte.views

import androidx.appcompat.app.AppCompatActivity

/*
* Created by Juhyang on 2021/10/04
*/

abstract class BaseActivity : AppCompatActivity() {
    override fun onResume() {
        super.onResume()

        setActionBar()
        loadData()
    }

    abstract fun setActionBar()
    abstract fun loadData()
}
