package com.educode.examentottus

import android.app.Application
import com.educode.examentottus.module.initDI

class TottusApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }
}