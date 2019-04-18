package android.itacademy.by.dz6.recycle

import android.widget.ImageView

import com.squareup.picasso.Picasso

object ImageLoaderUtil {
    fun loadImage(imageView: ImageView, url: String) {
        Picasso.get().load(url).into(imageView)
    }
}