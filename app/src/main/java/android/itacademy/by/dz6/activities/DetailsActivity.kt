package android.itacademy.by.dz6.activities

import android.content.Intent
import android.itacademy.by.dz6.fragments.DetailsFragment
import android.itacademy.by.dz6.student.Catalogue
import android.itacademy.by.dz6.student.Student
import android.itacademy.by.menu.R
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

class DetailsActivity : AppCompatActivity(), DetailsFragment.DetailsActions {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity_layout)

        intent = getIntent()

        val detailsFragment = DetailsFragment()

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.detailsSinglePan, detailsFragment)

        ft.commit()
    }

    override fun deleteAndExit(id: Int) {
        Catalogue.instance.list.removeAt(id)
        onBackPressed()
    }

    override fun saveAndExit(id: Int, name: String, lastName: String) {
        Catalogue.instance.list.get(id).firstName = name
        Catalogue.instance.list.get(id).lastName = lastName
        onBackPressed()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun initializeData() {
        val detailsFragment = supportFragmentManager
                .findFragmentById(R.id.detailsSinglePan) as DetailsFragment?
        detailsFragment?.initializeData(intent!!.getIntExtra("ID", 0))
    }
}