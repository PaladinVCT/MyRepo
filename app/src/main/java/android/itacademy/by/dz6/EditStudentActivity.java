package android.itacademy.by.dz6;

import android.app.Activity;
import android.content.Intent;
import android.itacademy.by.menu.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class EditStudentActivity extends Activity implements View.OnClickListener {
    private EditText editName;
    private EditText editLastname;
    private ImageView editPhoto;
    private Button saveButton;
    private Button deleteButton;
    private int id;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_student_layout);
        editName = findViewById(R.id.editStudentName);
        editLastname = findViewById(R.id.editStudentLastname);
        editPhoto = findViewById(R.id.editStudentPhoto);
        saveButton = findViewById(R.id.studentSaveButton);
        deleteButton = findViewById(R.id.studentDeleteButton);
        saveButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);

        Intent intent = getIntent();

        id = intent.getIntExtra("ID",0);
        editName.setText(intent.getStringExtra("NAME"));
        editLastname.setText(intent.getStringExtra("LASTNAME"));
        ImageLoaderUtil.loadImage(editPhoto, intent.getStringExtra("PHOTO"));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back_enter, R.anim.back_exit);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.studentSaveButton: {
                Catalogue.getInstance().getStudent(id).setFirstName(editName.getText().toString());
                Catalogue.getInstance().getStudent(id).setLastName(editLastname.getText().toString());
                onBackPressed();
                break;
            }
            case R.id.studentDeleteButton: {
                Catalogue.getInstance().deleteStudent(id);
                onBackPressed();
                break;
            }
        }
    }
}
