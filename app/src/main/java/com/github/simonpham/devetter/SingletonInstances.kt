package com.github.simonpham.devetter

import android.annotation.SuppressLint
import android.content.Context

/**
 * Created by Simon Pham on 6/12/18.
 * Email: simonpham.dn@gmail.com
 */

class SingletonInstances private constructor(private val appContext: Context) {

    companion object {

        @SuppressLint("StaticFieldLeak")
        private lateinit var INSTANCE: SingletonInstances
        private var initialized = false

        fun init(context: Context) {
            check(!initialized, { "Only init once" })
            INSTANCE = SingletonInstances(context.applicationContext)
            initialized = true
        }

        fun getAppContext() = INSTANCE.appContext

        fun getDevSetter() = INSTANCE.devSetterLazy
    }

    private val devSetterLazy by lazy { DevSetter(getAppContext()) }
}
