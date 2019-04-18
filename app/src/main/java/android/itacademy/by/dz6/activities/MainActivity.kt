package android.itacademy.by.dz6.activities

import android.content.Intent
import android.itacademy.by.dz6.dagger.DaggerMagicBox
import android.itacademy.by.dz6.fragments.DetailsFragment
import android.itacademy.by.dz6.fragments.StudentListFragment
import android.itacademy.by.dz6.recycle.StudentAdapter
import android.itacademy.by.dz6.student.Catalogue
import android.itacademy.by.menu.R
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import javax.inject.Inject

class MainActivity : AppCompatActivity(), StudentListFragment.OnAddClickListener, StudentAdapter.OnItemClickListener, DetailsFragment.DetailsActions {

    private var dualPan: Boolean = false
    private var id: Int = 0

    @Inject
    lateinit var catalogue: Catalogue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val component = DaggerMagicBox.builder().build()
        catalogue = component.provideCatalogue()

        setContentView(R.layout.main_layout)
        val detailsFrame = findViewById<View>(R.id.fragmentDetails)
        if (detailsFrame != null) {
            dualPan = true
        }
    }

    override fun startCreateActivity() {
        val intent = Intent(this, CreateActivity::class.java)
        startActivity(intent)
    }

    override fun onItemClick(id: Int) {

        if (dualPan) {

            val detailsFragment = DetailsFragment()
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragmentDetails, detailsFragment)
            ft.commit()
            this.id = id

        } else {

            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("ID", id)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        refresh()
    }

    override fun initializeData() {
        val detailsFragment = supportFragmentManager.findFragmentById(R.id.fragmentDetails) as DetailsFragment?
        detailsFragment?.initializeData(id)
    }

    override fun saveAndExit(id: Int, name: String, lastName: String) {
        catalogue.list.get(id).firstName = name
        catalogue.list.get(id).lastName = lastName
        removeDetailsFragment()
        refresh()
    }

    override fun deleteAndExit(id: Int) {
        catalogue.list.removeAt(id)
        removeDetailsFragment()
        refresh()
    }

    fun refresh() {
        val studentListFragment = supportFragmentManager
                .findFragmentById(R.id.fragmentRecycle) as StudentListFragment?
        if (studentListFragment != null) {
            studentListFragment.adapter?.notifyDataSetChanged()
        }
    }

    fun removeDetailsFragment() {
        val detailsFragment = supportFragmentManager.findFragmentById(R.id.fragmentDetails) as DetailsFragment?
        val ft = supportFragmentManager.beginTransaction()
        if (detailsFragment != null) {
            ft.remove(detailsFragment)
            ft.commit()
        }
    }

    override fun onPause() {
        super.onPause()
        removeDetailsFragment()
    }
}