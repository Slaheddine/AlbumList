package me.slaheddine.leboncoin

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AlbumsTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AlbumsTestApplication)
            modules(appModules)
        }
    }
}
