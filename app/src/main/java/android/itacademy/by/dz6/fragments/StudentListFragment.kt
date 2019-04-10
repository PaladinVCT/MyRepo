package android.itacademy.by.dz6.fragments

import android.content.Context
import android.itacademy.by.dz6.recycle.StudentAdapter
import android.itacademy.by.dz6.retrofit.provideApi
import android.itacademy.by.dz6.student.LocalStudentList
import android.itacademy.by.dz6.student.Student
import android.itacademy.by.menu.R
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ProgressBar
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.recycle_layout.*
import kotlin.collections.ArrayList

class StudentListFragment : Fragment() {

    private var catalogueCopy: ArrayList<Student>? = null

    lateinit var onAddClickListener: OnAddClickListener

    interface OnAddClickListener {
        fun startCreateActivity()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        onAddClickListener = context as OnAddClickListener
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.recycle_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestListStudents()


        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { onAddClickListener.startCreateActivity() }
        fab.alpha = 0.6f

        val search = view.findViewById<EditText>(R.id.editTextSearch)
        search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                if (catalogueCopy != null) {
                    filter(s.toString())
                }
            }
        })
    }

    private fun filter(enteredText: String) {
        var filteredList = ArrayList<Student>()
        val originalList = LocalStudentList.instance.list

        if (!TextUtils.isEmpty(enteredText)) {
            if (originalList != null) {
                for (student in originalList) {
                    if (student.NAME.toLowerCase().contains(enteredText.toLowerCase())
                            || student.LAST_NAME.toLowerCase().contains(enteredText.toLowerCase())) {
                        filteredList.add(student);
                    }
                }
            }
        } else {
            filteredList = this.catalogueCopy!!
        }
        setupRecycler(filteredList);
    }

    fun setupRecycler(studentList: List<Student>) {
        recyclerDz6.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerDz6.layoutManager = layoutManager
        recyclerDz6.adapter = StudentAdapter(studentList, context)
    }

    fun requestListStudents() {

        val disposable = provideApi().getStudents()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result ->
                            LocalStudentList.instance.list = result
                            this.catalogueCopy = result
                            setupRecycler(result)
                            progressStudentLoad.visibility = View.GONE
                        }
                        ,
                        { error -> Log.e("ERROR", error.message) }
                )
    }

    override fun onResume() {
        super.onResume()
        if (recyclerDz6.adapter != null) {
            setupRecycler(LocalStudentList.instance.list!!)
            recyclerDz6.adapter!!.notifyDataSetChanged()
        }
    }
}