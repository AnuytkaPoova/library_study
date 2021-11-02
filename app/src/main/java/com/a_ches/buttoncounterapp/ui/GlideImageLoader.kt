package com.a_ches.buttoncounterapp.ui

import android.widget.ImageView
import com.a_ches.buttoncounterapp.model.convertimagefile.IImageLoader
import com.bumptech.glide.Glide

class GlideImageLoader : IImageLoader<ImageView> {
    override fun loadInto(url: String, container: ImageView) {
        Glide.with(container)
            .load(url)
            .into(container)
    }
}