package android.itacademy.by.dz14.recycler

import android.itacademy.by.dz14.entity.Person
import android.itacademy.by.dz14.imageloader.ImageLoaderUtil
import android.itacademy.by.menu.R
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val photoImageView: ImageView
    private val nameTextView: TextView
    private val lastNameTextView: TextView
    private val ageTextView: TextView
    private val sexTextView: TextView

    init {
        photoImageView = itemView.findViewById<ImageView>(R.id.person_photo)
        nameTextView = itemView.findViewById<TextView>(R.id.person_name)
        lastNameTextView = itemView.findViewById<TextView>(R.id.person_surname)
        ageTextView = itemView.findViewById<TextView>(R.id.person_age)
        sexTextView = itemView.findViewById<TextView>(R.id.person_sex)
    }

    fun bind(person: Person) {
        nameTextView.setText(person.name)
        lastNameTextView.setText(person.surname)
        ageTextView.setText(person.age)
        sexTextView.setText(person.sex.toString())
        ImageLoaderUtil.loadImage(photoImageView, person.urlPhoto)
    }
}