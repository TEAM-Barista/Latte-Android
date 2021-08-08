package com.barista.latte.views

import androidx.fragment.app.Fragment

/**

 * Created by juhyang on 2021/08/08.

 */
abstract class BaseFragment : Fragment() {
    override fun onResume() {
        super.onResume()

        setActionBar()
        loadData()
    }

    abstract fun setActionBar()
    abstract fun loadData()
}
