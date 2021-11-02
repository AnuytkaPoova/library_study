package com.a_ches.buttoncounterapp.model.convertimagefile

import android.app.Application
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.a_ches.buttoncounterapp.presenter.convertimagefile.IFileStorage
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException

class FileStorage (
    private val context: Application
) : IFileStorage {

    override fun readFile(fileName: String): Single<ByteArray> =
        Single.create<ByteArray> {
            val file = File(context.filesDir, fileName)
            if (!file.exists()) {
                it.onError(IOException("not found file to convert: ${file.canonicalPath}"))
                return@create
            } else if (!file.canRead()) {
                it.onError(IOException("file '${file.canonicalPath}' is not readable"))
                return@create
            }
            it.onSuccess(file.readBytes())
        }.subscribeOn(Schedulers.io())

    override fun writeFile(bufferData: ByteArray, fileName: String): Completable =
        Completable.create {
            val file = File(context.filesDir, fileName)
            if (file.exists()) {
                file.delete()
            }
            file.writeBytes(bufferData)
            it.onComplete()
        }.subscribeOn(Schedulers.io())
}