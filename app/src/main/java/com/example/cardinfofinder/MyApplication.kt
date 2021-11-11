package com.example.cardinfofinder

import android.app.Application
import com.example.cardinfofinder.di.AppComponent
import com.example.cardinfofinder.di.DaggerAppComponent
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
open class MyApplication : Application() {

    val appComponent: AppComponent
        get() = DaggerAppComponent.create()

    override fun onCreate() {
        super.onCreate()
    }

}