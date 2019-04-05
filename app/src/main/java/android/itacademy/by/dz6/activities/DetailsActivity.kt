package android.itacademy.by.dz6.activities

import android.itacademy.by.dz6.fragments.DetailsFragment
import android.itacademy.by.dz6.retrofit.provideApi
import android.itacademy.by.dz6.student.LocalStudentList
import android.itacademy.by.menu.R
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        val student = LocalStudentList.instance.list!!.get(id)
        val objectId = student.objectId
        provideApi().deleteStudent(objectId).enqueue(object : Callback<Void> {
            override fun onFailure(call: Call<Void>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<Void>?, response: Response<Void>?) {

            }
        })
            LocalStudentList.instance.list!!.remove(student)
        onBackPressed()
    }

    override fun saveAndExit(id: Int, name: String, lastName: String) {
        val student = LocalStudentList.instance.list!!.get(id)
        student.NAME = name
        student.LAST_NAME = lastName
        provideApi().editStudent(student.objectId, student).enqueue(object : Callback<Void> {
            override fun onFailure(call: Call<Void>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                LocalStudentList.instance.list!!.get(id).NAME = name
                LocalStudentList.instance.list!!.get(id).LAST_NAME = lastName

            }
        })

        onBackPressed()
    }

    override fun initializeData() {
        val detailsFragment = supportFragmentManager
                .findFragmentById(R.id.detailsSinglePan) as DetailsFragment?
        detailsFragment?.initializeData(intent!!.getIntExtra("ID", 0))
    }
}