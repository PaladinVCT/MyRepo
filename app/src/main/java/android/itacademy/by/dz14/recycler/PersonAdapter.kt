package android.itacademy.by.dz14.recycler

import android.content.Context
import android.content.Intent
import android.itacademy.by.dz14.activities.DetailsActivity
import android.itacademy.by.dz14.entity.Person
import android.itacademy.by.menu.R
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class PersonAdapter(private val list: List<Person>,
                    private val context: Context) : RecyclerView.Adapter<PersonViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, num: Int): PersonViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_person, viewGroup, false)

        val holder = PersonViewHolder(view)

        val intent = Intent(context, DetailsActivity::class.java)
        intent.putExtra("ID", num)
        view.setOnClickListener {
            startActivity(it.context, intent, Bundle.EMPTY)
        }
        return holder
    }

    override fun onBindViewHolder(personViewHolder: PersonViewHolder, num: Int) {

        personViewHolder.bind(list.get(num))

    }

    override fun getItemCount(): Int {
        return list.size
    }
}