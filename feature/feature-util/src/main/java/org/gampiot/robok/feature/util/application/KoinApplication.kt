package org.gampiot.robok.feature.util.application

import android.app.Application

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

import org.gampiot.robok.feature.util.di.appModule
import org.gampiot.robok.feature.util.di.appPreferencesModule

open class KoinApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@KoinApplication)
            modules(
                appModule,
                appPreferencesModule
            )
        }
    }
}