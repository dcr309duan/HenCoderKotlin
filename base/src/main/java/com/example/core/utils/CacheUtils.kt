package com.example.core.utils

import android.content.Context
import com.example.core.BaseApplication
import com.example.core.R

/**
 * @author dcr
 * @date 2020/7/10  19:26
 */

object CacheUtils {
    private val context = BaseApplication.currentApplication()

    private val SP = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    fun save(key: String?, value: String?) {
        SP.edit().putString(key, value).apply()
    }

    operator fun get(key: String?): String? {
        return SP.getString(key, null)
    }
}