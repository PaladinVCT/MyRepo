package android.itacademy.by.dz14.activities

import android.arch.lifecycle.ViewModelProviders
import android.itacademy.by.dz14.recycler.PersonAdapter
import android.itacademy.by.dz14.viewmodel.PersonViewModel
import android.itacademy.by.menu.R
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.dz14_layout.*


class Dz14Activity : AppCompatActivity() {

    lateinit var personViewModel: PersonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dz14_layout)

        personViewModel = ViewModelProviders.of(this).get(PersonViewModel::class.java)

        val recycler = personRecycler
        recycler.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler.layoutManager = layoutManager
        val adapter = PersonAdapter(personViewModel.list, this)
        recycler.adapter = adapter


    }
}