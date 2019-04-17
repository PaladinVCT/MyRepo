package android.itacademy.by.dz14.imageloader

import android.itacademy.by.menu.R
import android.widget.ImageView

import com.squareup.picasso.Picasso

object ImageLoaderUtil {
    fun loadImage(imageView: ImageView, url: String) {

        Picasso.get()
                .load(url)
                .placeholder(R.drawable.progress)
                .error(R.drawable.inset_oval)
                .into(imageView)
    }
}