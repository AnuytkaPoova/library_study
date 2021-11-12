package com.a_ches.buttoncounterapp.di

import com.a_ches.buttoncounterapp.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(context: App) {

    private val app = context

    @Singleton
    @Provides
    fun getAppContext(): App = app
}