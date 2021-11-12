package com.a_ches.buttoncounterapp.presenter.convertimagefile

import io.reactivex.rxjava3.core.Single

interface IImageConvertor {
    fun convertToPng(bufferData: ByteArray): Single<ByteArray>
}

