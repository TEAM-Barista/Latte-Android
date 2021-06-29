package com.barista.latte.views

import android.app.Activity
import android.view.LayoutInflater
import androidx.appcompat.app.ActionBar
import com.barista.latte.R

/**

 * Created by juhyang on 2021/06/29.

 */
class LatteActionBar(private val activity : Activity, private val actionBar : ActionBar?) {
    fun setActionBar() {
        actionBar?.setDisplayShowCustomEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(false)
        actionBar?.setDisplayShowTitleEnabled(false)

        val view = LayoutInflater.from(activity).inflate(R.layout.custom_actionbar, null)
        actionBar?.customView = view
    }
}
