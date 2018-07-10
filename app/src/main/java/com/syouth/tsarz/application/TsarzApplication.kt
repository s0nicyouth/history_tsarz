package com.syouth.tsarz.application

import android.app.Application

class TsarzApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        AppComponentHolder.init()
    }
}