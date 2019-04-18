package android.itacademy.by.dz6.recycle

import android.content.Context
import android.itacademy.by.dz6.student.Catalogue
import android.itacademy.by.dz6.student.Student
import android.itacademy.by.menu.R
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import java.util.ArrayList

class StudentAdapter(private val context: Context) : RecyclerView.Adapter<StudentViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(id: Int)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        onItemClickListener = context as OnItemClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): StudentViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_student, viewGroup, false)
        val holder = StudentViewHolder(view)
        view.setOnClickListener { v -> onItemClickListener!!.onItemClick(holder.adapterPosition) }
        return holder
    }

    override fun onBindViewHolder(studentViewHolder: StudentViewHolder, id: Int) {
        studentViewHolder.bind(Catalogue.instance.list.get(id))

    }

    override fun getItemCount(): Int {
        return Catalogue.instance.list.size
    }

    fun filterList(filteredList: ArrayList<Student>) {
        Catalogue.instance.list.clear()
        Catalogue.instance.list.addAll(filteredList)
        notifyDataSetChanged()
    }
}