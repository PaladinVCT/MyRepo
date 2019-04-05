package android.itacademy.by.dz6.activities

import android.itacademy.by.dz6.fragments.DetailsFragment
import android.itacademy.by.dz6.retrofit.provideApi
import android.itacademy.by.dz6.student.LocalStudentList
import android.itacademy.by.menu.R
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import javax.security.auth.callback.Callback

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
        val objectId = LocalStudentList.instance.list!!.get(id).objectId
        provideApi().deleteStudent(objectId).enqueue(Callback<>
        )
        onBackPressed()
    }

    override fun saveAndExit(id: Int, name: String, lastName: String) {
        val student = LocalStudentList.instance.list!!.get(id)
        student.NAME = name
        student.LAST_NAME = lastName
        provideApi().editStudent(student.objectId,student).request()

        onBackPressed()
    }

    override fun initializeData() {
        val detailsFragment = supportFragmentManager
                .findFragmentById(R.id.detailsSinglePan) as DetailsFragment?
        detailsFragment?.initializeData(intent!!.getIntExtra("ID", 0))
    }
}