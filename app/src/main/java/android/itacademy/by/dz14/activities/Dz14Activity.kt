package android.itacademy.by.dz14.activities

import android.itacademy.by.dz14.recycler.PersonAdapter
import android.itacademy.by.dz14.viewmodel.PersonViewModel
import android.itacademy.by.menu.R
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.dz14_layout.*
import android.arch.lifecycle.ViewModelProviders
import android.itacademy.by.dz14.entity.Person
import android.itacademy.by.dz14.entity.sex
import android.support.v7.widget.RecyclerView


class Dz14Activity:AppCompatActivity() {

    private var personViewModel: PersonViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.dz14_layout)

       val recyclerView = findViewById<RecyclerView>(R.id.personRecycler)

        personViewModel = ViewModelProviders.of(this).get(PersonViewModel::class.java)

        recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        val list = ArrayList<Person>()
        list.add(0,Person("https://upload.wikimedia.org/wikipedia/ru/thumb/f/f9/Philadelphia_Eagles_primary_logo.png/1600px-Philadelphia_Eagles_primary_logo.png",
                "Ivan","Kotlin",30, sex = sex.M))
        list.add(0,Person("https://upload.wikimedia.org/wikipedia/ru/thumb/f/f9/Philadelphia_Eagles_primary_logo.png/1600px-Philadelphia_Eagles_primary_logo.png",
                "Ivan","Kotlin",30, sex = sex.M))
        list.add(0,Person("https://upload.wikimedia.org/wikipedia/ru/thumb/f/f9/Philadelphia_Eagles_primary_logo.png/1600px-Philadelphia_Eagles_primary_logo.png",
                "Ivan","Kotlin",30, sex = sex.M))

        recyclerView.adapter = PersonAdapter(list, this)

    }
}