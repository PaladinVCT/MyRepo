package android.itacademy.by.dz6.recycle

import android.content.Context
import android.itacademy.by.dz6.student.Student
import android.itacademy.by.menu.R
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import java.util.*

class StudentAdapter(
        private val studentList: List<Student>,
        private val context: Context?) : RecyclerView.Adapter<StudentViewHolder>() {

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

        studentViewHolder.bind(studentList.get(id))
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    fun filterList(filteredList: ArrayList<Student>) {
//        LocalStudentList.getInstance().getFullList().clear()
//        LocalStudentList.getInstance().getFullList().addAll(filteredList)
//        notifyDataSetChanged()
    }
}