package com.github.simonpham.devetter

import android.content.Context
import android.content.res.Configuration
import android.provider.Settings
import android.util.Log

/**
 * Created by Simon Pham on 6/12/18.
 * Email: simonpham.dn@gmail.com
 */

class DevSetter(val context: Context) {

    private val TAG = "Devetter"

    fun setGlobal(key: String, value: Int) {
        try {
            Settings.Global.putInt(context.contentResolver, key, value)
        } catch (se: SecurityException) {
            Log.d(TAG, "Not granted permission!")
        }
    }

    fun setGlobal(key: String, value: Long) {
        try {
            Settings.Global.putLong(context.contentResolver, key, value)
        } catch (se: SecurityException) {
            Log.d(TAG, "Not granted permission!")
        }
    }

    fun setGlobal(key: String, value: Float) {
        try {
            Settings.Global.putFloat(context.contentResolver, key, value)
        } catch (se: SecurityException) {
            Log.d(TAG, "Not granted permission!")
        }
    }

    fun setGlobal(key: String, value: String) {
        try {
            Settings.Global.putString(context.contentResolver, key, value)
        } catch (se: SecurityException) {
            Log.d(TAG, "Not granted permission!")
        }
    }

    // require targetSdkVersion 22 in app build.gradle
    fun setSystem(key: String, value: Int) {
        try {
            Settings.System.putInt(context.contentResolver, key, value)
        } catch (se: SecurityException) {
            Log.d(TAG, "Not granted permission!")
        } catch (e: IllegalArgumentException) {
            Log.d(TAG, "Failed to set system value!")
        }
    }

    fun setSystem(key: String, value: Long) {
        try {
            Settings.System.putLong(context.contentResolver, key, value)
        } catch (se: SecurityException) {
            Log.d(TAG, "Not granted permission!")
        } catch (e: IllegalArgumentException) {
            Log.d(TAG, "Failed to set system value!")
        }
    }

    fun setSystem(key: String, value: Float) {
        try {
            Settings.System.putFloat(context.contentResolver, key, value)
        } catch (se: SecurityException) {
            Log.d(TAG, "Not granted permission!")
        } catch (e: IllegalArgumentException) {
            Log.d(TAG, "Failed to set system value!")
        }
    }

    fun setSystem(key: String, value: String) {
        try {
            Settings.System.putString(context.contentResolver, key, value)
        } catch (se: SecurityException) {
            Log.d(TAG, "Not granted permission!")
        } catch (e: IllegalArgumentException) {
            Log.d(TAG, "Failed to set system value!")
        }
    }

    fun setSecure(key: String, value: Int) {
        try {
            Settings.Secure.putInt(context.contentResolver, key, value)
        } catch (se: SecurityException) {
            Log.d(TAG, "Not granted permission!")
        } catch (e: IllegalArgumentException) {
            Log.d(TAG, "Failed to set system value!")
        }
    }

    fun setSecure(key: String, value: Long) {
        try {
            Settings.Secure.putLong(context.contentResolver, key, value)
        } catch (se: SecurityException) {
            Log.d(TAG, "Not granted permission!")
        } catch (e: IllegalArgumentException) {
            Log.d(TAG, "Failed to set system value!")
        }
    }

    fun setSecure(key: String, value: Float) {
        try {
            Settings.Secure.putFloat(context.contentResolver, key, value)
        } catch (se: SecurityException) {
            Log.d(TAG, "Not granted permission!")
        } catch (e: IllegalArgumentException) {
            Log.d(TAG, "Failed to set system value!")
        }
    }

    fun setSecure(key: String, value: String) {
        try {
            Settings.Secure.putString(context.contentResolver, key, value)
        } catch (se: SecurityException) {
            Log.d(TAG, "Not granted permission!")
        } catch (e: IllegalArgumentException) {
            Log.d(TAG, "Failed to set system value!")
        }
    }
}
