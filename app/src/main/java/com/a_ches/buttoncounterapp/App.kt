package com.a_ches.buttoncounterapp

import android.app.Application
import android.util.Log
import android.widget.Toast
import com.a_ches.buttoncounterapp.di.AppComponent
import com.a_ches.buttoncounterapp.di.AppModule
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.exceptions.UndeliverableException
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import com.a_ches.buttoncounterapp.di.DaggerAppComponent

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        instance = this

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

        RxJavaPlugins.setErrorHandler {
            Log.e("App", it.message ?: "")
        }
    }
}