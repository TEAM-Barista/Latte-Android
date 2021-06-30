package com.barista.latte.views

import android.app.Activity
import android.view.LayoutInflater
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import com.barista.latte.R

/**

 * Created by juhyang on 2021/06/29.

 */
class LatteActionBar(private val activity : Activity, private val actionBar : ActionBar) {
    fun setActionBar() {
        actionBar.setDisplayShowCustomEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(false)
        actionBar.setDisplayShowTitleEnabled(false)

        val view = LayoutInflater.from(activity).inflate(R.layout.latte_actionbar, null)
        actionBar.customView = view

        val parent : Toolbar = view.parent as Toolbar

        parent.setContentInsetsAbsolute(0, 0)

        val params = ActionBar.LayoutParams(
            ActionBar.LayoutParams.MATCH_PARENT,
            ActionBar.LayoutParams.MATCH_PARENT
        )
        actionBar.setCustomView(view, params)
    }
}
