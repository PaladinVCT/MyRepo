package android.itacademy.by.dz6.fragments

import android.content.Context
import android.itacademy.by.dz6.recycle.StudentAdapter
import android.itacademy.by.dz6.student.Catalogue
import android.itacademy.by.dz6.student.Student
import android.itacademy.by.menu.R
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

import java.util.ArrayList

class StudentListFragment : Fragment() {

    var adapter: StudentAdapter? = null
        private set
    private var catalogueCopy: MutableList<Student>? = null

    lateinit var onAddClickListener: OnAddClickListener

    interface OnAddClickListener {
        fun startCreateActivity()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        onAddClickListener = (context as OnAddClickListener?)!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.recycle_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        catalogueCopy = ArrayList()
        adapter = StudentAdapter(view.context)

        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { onAddClickListener.startCreateActivity() }
        fab.alpha = 0.6f
        val rView = view.findViewById<RecyclerView>(R.id.recyclerDz6)
        rView.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(view.context)
        rView.layoutManager = linearLayoutManager
        rView.adapter = adapter

        val search = view.findViewById<EditText>(R.id.editTextSearch)
        search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                filter(s.toString())
            }
        })

        for (i in 0 until Catalogue.instance.list.size) {
            catalogueCopy!!.add(Catalogue.instance.list.get(i))
        }
    }


    private fun filter(text: String) {
        val filteredList = ArrayList<Student>()
        val originalList = ArrayList<Student>()
        for (i in 0 until Catalogue.instance.list.size) {
            originalList.add(Catalogue.instance.list.get(i))
        }
        if (!TextUtils.isEmpty(text)) {
            for (student in originalList) {
                if (student.firstName!!.toLowerCase().contains(text.toLowerCase()) || student.lastName!!.toLowerCase().contains(text.toLowerCase())) {
                    filteredList.add(student)
                }
            }
        } else
            filteredList.addAll(catalogueCopy!!)
        adapter!!.filterList(filteredList)
    }
}