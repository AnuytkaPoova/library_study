package com.a_ches.buttoncounterapp.model.convertimagefile

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}