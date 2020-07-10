package com.example.core

import android.app.Application
import android.content.Context

/**
 * @author dcr
 * @date 2020/7/10  19:32
 */
class BaseApplication : Application() {
    companion object {
        private lateinit var currentApplication: Context

        fun currentApplication(): Context {
            return currentApplication
        }
    }

    override fun onCreate() {
        super.onCreate()
        currentApplication = this
    }
}