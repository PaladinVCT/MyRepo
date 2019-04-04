package android.itacademy.by.dz6.recycle

import android.content.Context
import android.itacademy.by.dz6.retrofit.RetrofitActivity
import android.itacademy.by.dz6.student.Catalogue
import android.itacademy.by.dz6.student.Student
import android.itacademy.by.menu.R
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.reactivestreams.Subscriber

import java.util.ArrayList
import javax.security.auth.callback.Callback

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

    override fun onBindViewHolder(studentViewHolder: StudentViewHolder, Id: Int) {
        studentViewHolder.bind(Catalogue.getInstance().getStudent(Id))

        val request = RetrofitActivity().getApi()
        val b = request.getStudents().map {Catalogue->
            Catalogue.studentsList
        }
        val c =b.blockingGet()
        c.get(0)

        }

    }


}

override fun getItemCount(): Int {
    return Catalogue.getInstance().countStudents()
}

fun filterList(filteredList: ArrayList<Student>) {
    Catalogue.getInstance().getFullList().clear()
    Catalogue.getInstance().getFullList().addAll(filteredList)
    notifyDataSetChanged()
}
}