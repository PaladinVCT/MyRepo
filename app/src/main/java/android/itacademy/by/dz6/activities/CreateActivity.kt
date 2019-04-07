package android.itacademy.by.dz6.activities

import android.app.Activity
import android.itacademy.by.dz6.retrofit.provideApi
import android.itacademy.by.dz6.student.LocalStudentList
import android.itacademy.by.dz6.student.Student
import android.itacademy.by.menu.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateActivity : Activity(), View.OnClickListener {
    private var photo: EditText? = null
    private var firstName: EditText? = null
    private var lastName: EditText? = null
    private var create: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_student_layout)
        photo = findViewById(R.id.createStudentPhoto)
        firstName = findViewById(R.id.createStudentName)
        lastName = findViewById(R.id.createStudentLastname)
        create = findViewById(R.id.studentCreateButton)
        create!!.setOnClickListener(this)
        overridePendingTransition(R.anim.back_enter, R.anim.back_exit)
    }

    override fun onClick(v: View) {
        if (photo!!.text.toString() == "") {
            photo!!.setText("https://www.rencoroofing.com/wp-content/uploads/2018/09/1.png")
        }
        if (firstName!!.text.toString() == "") {
            firstName!!.setText("John")
        }
        if (lastName!!.text.toString() == "") {
            lastName!!.setText("Smith")
        }

        val student = Student(photo.toString(), LocalStudentList.instance.list!!.size,
                lastName.toString(), "", firstName.toString())

        provideApi().createStudent(student).enqueue(object : Callback<Void> {
            override fun onFailure(call: Call<Void>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
            }
        })
        LocalStudentList.instance.list!!.add(student)
        onBackPressed()
    }
}