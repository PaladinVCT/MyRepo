package android.itacademy.by.dz6.activities

import android.app.Activity
import android.itacademy.by.dz6.student.Catalogue
import android.itacademy.by.dz6.student.Student
import android.itacademy.by.menu.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

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
        Catalogue.instance.list.add(Student(firstName!!.text.toString(), lastName!!.text
                        .toString(), photo!!.text.toString()))

        onBackPressed()
    }

}