package com.a_ches.buttoncounterapp

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class App: Application() {
    //Application() живой пока работает приложение

    companion object {
        lateinit var instance: App
    }
    //временно до даггера положим это тут
    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }

    val navigatorHolder get() = cicerone.getNavigatorHolder()
    val router get() = cicerone.router


    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}