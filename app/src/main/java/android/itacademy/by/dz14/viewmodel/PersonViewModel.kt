package android.itacademy.by.dz14.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.BindingAdapter
import android.itacademy.by.dz14.entity.Person
import android.itacademy.by.dz14.entity.Sex
import android.widget.ImageView


class PersonViewModel : ViewModel() {

    var list = ArrayList<Person>()

    init {
        list.add(Person("https://upload.wikimedia.org/wikipedia/ru/thumb/f/f9/Philadelphia_Eagles_primary_logo.png/1600px-Philadelphia_Eagles_primary_logo.png",
                "Ivan", "Petrovich", 21, sex = Sex.M))
        list.add(Person("https://bumper-stickers.ru/47424-thickbox_default/gomer-simpson-v-stile-hippi.jpg",
                "Vovan", "Ivanych", 32, sex = Sex.M))
        list.add(Person("https://bumper-stickers.ru/38923-thickbox_default/zhenskij-siluet-v-shlyape.jpg",
                "Masha", "Petrovna", 19, sex = Sex.F))
        list.add(Person("https://www.clipartmax.com/png/middle/72-728469_mozilla-dinosaur-head-logo-red-dinosaur-head-logo.png",
                "Sasha", "Vovanovich", 31, sex = Sex.M))
        list.add(Person("http://3.bp.blogspot.com/-u3PYdoBDM2Y/URFzXGgVw3I/AAAAAAAAAYI/1tDzUXlXVLs/s1600/Silverback.jpg",
                "Vasya", "Ivanych", 60, sex = Sex.M))
        list.add(Person("https://static.tgstat.ru/public/images/channels/_0/8c/8c625d419cc9d0386eca18d97e8068bd.jpg",
                "Pasha", "Petrovich", 42, sex = Sex.M))
        list.add(Person("https://www.freegreatpicture.com/files/130/21658-fashion-women-wallpaper.jpg",
                "Lusia", "Ivanovna", 34, sex = Sex.F))
    }

    companion object {

        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, url: String) {
            android.itacademy.by.dz14.imageloader.ImageLoaderUtil.loadImage(view,url)
        }
    }
}