package android.itacademy.by.dz6.recycle;

import android.itacademy.by.dz6.student.Student;
import android.itacademy.by.menu.R;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class StudentViewHolder extends RecyclerView.ViewHolder {
    private ImageView photo;
    private TextView fName;
    private TextView lName;


    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        photo = itemView.findViewById(R.id.person_photo);
        fName = itemView.findViewById(R.id.person_name);
        lName = itemView.findViewById(R.id.person_surname);
    }

    public void bind(Student student) {
        if (student.getFirstName() != null) {
            fName.setText(student.getFirstName());
        } else {
            fName.setText("");
        }

        if (student.getLastName() != null) {
            lName.setText(student.getLastName());
        } else {
            lName.setText("");
        }

        if (student.getTextUrl() != null) {
            ImageLoaderUtil.loadImage(photo, student.getTextUrl());
        } else {
            photo.setImageDrawable(null);
        }
    }
}