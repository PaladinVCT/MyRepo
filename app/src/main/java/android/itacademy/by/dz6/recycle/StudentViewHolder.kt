package android.itacademy.by.dz6.recycle

import android.itacademy.by.dz6.student.Student
import android.itacademy.by.menu.R
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView


class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val photoImageView: ImageView
    private val nameTextView: TextView
    private val lastNameTextView: TextView


    init {
        photoImageView = itemView.findViewById(R.id.person_photo)
        nameTextView = itemView.findViewById(R.id.person_name)
        lastNameTextView = itemView.findViewById(R.id.person_surname)
    }

    fun bind(student: Student) {
        if (student.NAME != null) {
            nameTextView.setText(student.NAME)
        } else {
            nameTextView.text = ""
        }

        if (student.LAST_NAME != null) {
            lastNameTextView.setText(student.LAST_NAME)
        } else {
            lastNameTextView.text = ""
        }

        if (student.PHOTO_URL != null) {
            ImageLoaderUtil.loadImage(photoImageView, student.PHOTO_URL)
        } else {
            photoImageView.setImageDrawable(null)
        }
    }
}