package com.github.simonpham.devetter

import android.app.IntentService
import android.content.Context
import android.content.Intent

private const val ACTION_PUT_GLOBAL = "com.github.simonpham.devetter.action.PUT_GLOBAL"
private const val ACTION_PUT_SECURE = "com.github.simonpham.devetter.action.PUT_SECURE"
private const val ACTION_PUT_SYSTEM = "com.github.simonpham.devetter.action.PUT_SYSTEM"

private const val EXTRA_KEY = "com.github.simonpham.devetter.extra.KEY"
private const val EXTRA_VALUE = "com.github.simonpham.devetter.extra.VALUE"
private const val EXTRA_VALUE_TYPE = "com.github.simonpham.devetter.extra.VALUE_TYPE"

class DevetterService : IntentService("DevetterService") {

    private val devSetter = SingletonInstances.getDevSetter()

    override fun onHandleIntent(intent: Intent?) {
        when (intent?.action) {
            ACTION_PUT_GLOBAL -> {
                val key = intent.getStringExtra(EXTRA_KEY)
                val value = intent.getStringExtra(EXTRA_VALUE)
                val dataType = intent.getIntExtra(EXTRA_VALUE_TYPE, DATA_TYPE_STRING)
                globalSetter(key, value, dataType)
            }
            ACTION_PUT_SECURE -> {
                val key = intent.getStringExtra(EXTRA_KEY)
                val value = intent.getStringExtra(EXTRA_VALUE)
                val dataType = intent.getIntExtra(EXTRA_VALUE_TYPE, DATA_TYPE_STRING)
                secureSetter(key, value, dataType)
            }
            ACTION_PUT_SYSTEM -> {
                val key = intent.getStringExtra(EXTRA_KEY)
                val value = intent.getStringExtra(EXTRA_VALUE)
                val dataType = intent.getIntExtra(EXTRA_VALUE_TYPE, DATA_TYPE_STRING)
                systemSetter(key, value, dataType)
            }
        }
    }

    private fun globalSetter(key: String, value: String, valueType: Int) {
        when (valueType) {
            DATA_TYPE_INT -> devSetter.setGlobal(key, value.toInt())
            DATA_TYPE_LONG -> devSetter.setGlobal(key, value.toLong())
            DATA_TYPE_FLOAT -> devSetter.setGlobal(key, value.toFloat())
            DATA_TYPE_STRING -> devSetter.setGlobal(key, value)
            else -> throw IllegalArgumentException("Unknown data type $valueType")
        }
    }

    private fun secureSetter(key: String, value: String, valueType: Int) {
        when (valueType) {
            DATA_TYPE_INT -> devSetter.setSecure(key, value.toInt())
            DATA_TYPE_LONG -> devSetter.setSecure(key, value.toLong())
            DATA_TYPE_FLOAT -> devSetter.setSecure(key, value.toFloat())
            DATA_TYPE_STRING -> devSetter.setSecure(key, value)
            else -> throw IllegalArgumentException("Unknown data type $valueType")
        }
    }

    private fun systemSetter(key: String, value: String, valueType: Int) {
        when (valueType) {
            DATA_TYPE_INT -> devSetter.setSystem(key, value.toInt())
            DATA_TYPE_LONG -> devSetter.setSystem(key, value.toLong())
            DATA_TYPE_FLOAT -> devSetter.setSystem(key, value.toFloat())
            DATA_TYPE_STRING -> devSetter.setSystem(key, value)
            else -> throw IllegalArgumentException("Unknown data type $valueType")
        }
    }

    companion object {

        @JvmStatic
        fun startDevSetter(
                context: Context,
                setType: Int,
                key: String,
                value: String,
                dataType: Int = DATA_TYPE_STRING
        ) {
            val intent = Intent(context, DevetterService::class.java).apply {
                action = when (setType) {
                    TYPE_GLOBAL -> ACTION_PUT_GLOBAL
                    TYPE_SECURE -> ACTION_PUT_SECURE
                    TYPE_SYSTEM -> ACTION_PUT_SYSTEM
                    else -> throw IllegalArgumentException("Wrong settings type $type")
                }
                putExtra(EXTRA_KEY, key)
                putExtra(EXTRA_VALUE, value)
                putExtra(EXTRA_VALUE_TYPE, dataType)
            }
            context.startService(intent)
        }
    }
}
