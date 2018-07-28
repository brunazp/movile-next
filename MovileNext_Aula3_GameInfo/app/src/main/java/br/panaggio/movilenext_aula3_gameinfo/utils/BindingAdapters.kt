package br.panaggio.movilenext_aula3_gameinfo.utils

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso


class BindingAdapters {
    companion object {
        @JvmStatic @BindingAdapter("image")
        fun loadImage(imageView: ImageView, imageUrl: String?) {
            Picasso.get().load(imageUrl).into(imageView)
        }
    }
}