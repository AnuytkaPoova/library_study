package com.a_ches.buttoncounterapp.di

import com.a_ches.buttoncounterapp.App
import com.a_ches.buttoncounterapp.model.AndroidNetworkStatus
import com.a_ches.buttoncounterapp.model.INetworkStatus
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkStatusModule {

    @Singleton
    @Provides
    fun networkStatus(context: App): INetworkStatus = AndroidNetworkStatus(context)
}