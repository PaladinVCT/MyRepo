package android.itacademy.by.dz6.recycle

import android.itacademy.by.dz6.imageloader.ImageLoaderUtil
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
        if (student.firstName != null) {
            nameTextView.text = student.firstName
        } else {
            nameTextView.text = ""
        }

        if (student.lastName != null) {
            lastNameTextView.text = student.lastName
        } else {
            lastNameTextView.text = ""
        }

        if (student.textUrl != null) {
            ImageLoaderUtil.loadImage(photoImageView, student.textUrl!!)
        } else {
            photoImageView.setImageDrawable(null)
        }
    }
}