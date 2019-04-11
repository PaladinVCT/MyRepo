package android.itacademy.by.dz14.activities

import android.itacademy.by.dz14.viewmodel.PersonViewModel
import android.itacademy.by.menu.R
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity


class Dz14Activity:AppCompatActivity() {

    private val personViewModel: PersonViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.dz14_layout)
    }
}