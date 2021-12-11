package com.barista.latte

import android.app.Application
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**

 * Created by juhyang on 2021/06/26.

 */

@HiltAndroidApp
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
