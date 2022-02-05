package com.example.watchapp

import android.app.Application
import com.example.watchapp.di.appModule
import org.koin.core.context.startKoin

class StopwatchApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
        }
    }
}