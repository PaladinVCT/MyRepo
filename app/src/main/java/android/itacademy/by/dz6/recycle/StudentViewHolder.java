package android.itacademy.by.dz6.recycle;

import android.itacademy.by.dz6.student.Student;
import android.itacademy.by.menu.R;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class StudentViewHolder extends RecyclerView.ViewHolder {
    private ImageView photoImageView;
    private TextView nameTextView;
    private TextView lastNameTextView;


    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        photoImageView = itemView.findViewById(R.id.person_photo);
        nameTextView = itemView.findViewById(R.id.person_name);
        lastNameTextView = itemView.findViewById(R.id.person_surname);
    }

    public void bind(Student student) {
        if (student.getFirstName() != null) {
            nameTextView.setText(student.getFirstName());
        } else {
            nameTextView.setText("");
        }

        if (student.getLastName() != null) {
            lastNameTextView.setText(student.getLastName());
        } else {
            lastNameTextView.setText("");
        }

        if (student.getTextUrl() != null) {
            ImageLoaderUtil.loadImage(photoImageView, student.getTextUrl());
        } else {
            photoImageView.setImageDrawable(null);
        }
    }
}