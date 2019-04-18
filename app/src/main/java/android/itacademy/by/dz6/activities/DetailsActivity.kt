package android.itacademy.by.dz6.activities

import android.itacademy.by.dz6.dagger.DaggerMagicBox
import android.itacademy.by.dz6.fragments.DetailsFragment
import android.itacademy.by.dz6.student.Catalogue
import android.itacademy.by.menu.R
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject

class DetailsActivity : AppCompatActivity(), DetailsFragment.DetailsActions {
    @Inject
    lateinit var catalogue: Catalogue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity_layout)

        val component = DaggerMagicBox.builder().build()

        catalogue = component.provideCatalogue()

        intent = getIntent()

        val detailsFragment = DetailsFragment()

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.detailsSinglePan, detailsFragment)

        ft.commit()
    }

    override fun deleteAndExit(id: Int) {
        catalogue.list.removeAt(id)
        onBackPressed()
    }

    override fun saveAndExit(id: Int, name: String, lastName: String) {
        catalogue.list.get(id).firstName = name
        catalogue.list.get(id).lastName = lastName
        onBackPressed()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun initializeData() {
        val detailsFragment = supportFragmentManager
                .findFragmentById(R.id.detailsSinglePan) as DetailsFragment?
        detailsFragment?.initializeData(intent.getIntExtra("ID", 0))
    }
}