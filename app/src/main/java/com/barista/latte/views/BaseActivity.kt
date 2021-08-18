package com.barista.latte.views

import androidx.appcompat.app.AppCompatActivity

/**

 * Created by juhyang on 2021/08/11.

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
