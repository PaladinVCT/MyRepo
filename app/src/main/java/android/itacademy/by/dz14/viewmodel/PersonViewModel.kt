package android.itacademy.by.dz14.viewmodel

import android.arch.lifecycle.ViewModel
import android.itacademy.by.dz14.entity.Person
import android.itacademy.by.dz14.entity.sex

class PersonViewModel : ViewModel() {

    var list = ArrayList<Person>()

    init {
        list.add(0,Person("https://upload.wikimedia.org/wikipedia/ru/thumb/f/f9/Philadelphia_Eagles_primary_logo.png/1600px-Philadelphia_Eagles_primary_logo.png",
                "Ivan","Kotlin",30, sex = sex.M))
        list.add(0,Person("https://upload.wikimedia.org/wikipedia/ru/thumb/f/f9/Philadelphia_Eagles_primary_logo.png/1600px-Philadelphia_Eagles_primary_logo.png",
                "Ivan","Kotlin",30, sex = sex.M))
        list.add(0,Person("https://upload.wikimedia.org/wikipedia/ru/thumb/f/f9/Philadelphia_Eagles_primary_logo.png/1600px-Philadelphia_Eagles_primary_logo.png",
                "Ivan","Kotlin",30, sex = sex.M))
    }
}