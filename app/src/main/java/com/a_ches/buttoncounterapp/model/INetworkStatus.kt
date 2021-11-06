package com.a_ches.buttoncounterapp.model

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface INetworkStatus {

    fun isOnline(): Observable<Boolean>
    fun isOnlineSingle(): Single<Boolean>
}