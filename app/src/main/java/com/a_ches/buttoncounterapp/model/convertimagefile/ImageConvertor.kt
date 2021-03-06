package com.a_ches.buttoncounterapp.model.convertimagefile

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.a_ches.buttoncounterapp.presenter.convertimagefile.IImageConvertor
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

object ImageConvertor : IImageConvertor {

    const val QUALITY_IMAGE_COMPRESSION = 100

    override fun convertToPng(bufferData: ByteArray): Single<ByteArray> =
        Single.create<ByteArray> {
            val bmp = BitmapFactory.decodeStream(ByteArrayInputStream(bufferData))
            val byteArrayOutputStream = ByteArrayOutputStream()
            bmp.compress(Bitmap.CompressFormat.PNG, QUALITY_IMAGE_COMPRESSION, byteArrayOutputStream)
            it.onSuccess(byteArrayOutputStream.toByteArray())
        }.subscribeOn(Schedulers.computation())
}