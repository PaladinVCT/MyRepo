package android.itacademy.by.dz6.activities;

import android.app.Activity;
import android.itacademy.by.menu.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateActivity extends Activity implements View.OnClickListener {
    private EditText photo;
    private EditText firstName;
    private EditText lastName;
    private Button create;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_student_layout);
        photo = findViewById(R.id.createStudentPhoto);
        firstName = findViewById(R.id.createStudentName);
        lastName = findViewById(R.id.createStudentLastname);
        create = findViewById(R.id.studentCreateButton);
        create.setOnClickListener(this);
        overridePendingTransition(R.anim.back_enter, R.anim.back_exit);
    }

    @Override
    public void onClick(View v) {
        if (photo.getText().toString().equals("")) {
            photo.setText("https://www.rencoroofing.com/wp-content/uploads/2018/09/1.png");
        }
        if (firstName.getText().toString().equals("")) {
            firstName.setText("John");
        }
        if (lastName.getText().toString().equals("")) {
            lastName.setText("Smith");
        }
//        LocalStudentList.getInstance()
//                .addStudent(new Student(firstName.getText().toString(), lastName.getText()
//                        .toString(), photo.getText().toString()));

        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}