package com.a_ches.buttoncounterapp.presenter.convertimagefile

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface IFileStorage {
    fun readFile(fileName: String): Single<ByteArray>
    fun writeFile(bufferData: ByteArray, fileName: String): Completable
}