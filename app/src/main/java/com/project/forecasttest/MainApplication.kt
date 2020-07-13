package com.project.forecasttest

import android.app.Application
import com.project.forecasttest.di.applicationModule
import com.project.forecasttest.di.networkModule
import com.project.forecasttest.di.feedModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        // start Koin!
        startKoin {
            // Android context
            androidContext(this@MainApplication)
            androidLogger(Level.DEBUG)
            androidFileProperties()
            // modules
            modules(applicationModule+networkModule+feedModule)
        }
    }
}