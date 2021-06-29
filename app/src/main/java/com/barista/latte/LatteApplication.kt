package com.barista.latte

import android.app.Application
import timber.log.Timber

/**

 * Created by juhyang on 2021/06/26.

 */
class LatteApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        setupTimber()
    }

    private fun setupTimber() {
        // Plant a tree
        Timber.plant(Timber.DebugTree())
    }
}
