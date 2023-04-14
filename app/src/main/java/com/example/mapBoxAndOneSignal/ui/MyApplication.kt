package com.example.mapBoxAndOneSignal.ui

import android.app.Application
import com.example.mapBoxAndOneSignal.core.koin.getListOfModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(getListOfModules())
        }
    }
}