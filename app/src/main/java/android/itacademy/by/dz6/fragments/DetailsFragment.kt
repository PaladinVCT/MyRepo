package android.itacademy.by.dz6.fragments

import android.content.Context
import android.itacademy.by.dz6.recycle.ImageLoaderUtil
import android.itacademy.by.dz6.student.LocalStudentList
import android.itacademy.by.menu.R
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class DetailsFragment : Fragment() {

    private var editName: EditText? = null
    private var editLastname: EditText? = null
    private var editPhoto: ImageView? = null
    private var saveButton: Button? = null
    private var deleteButton: Button? = null

    private var detailsActionsListener: DetailsActions? = null
    private var localId :Int = 0

    interface DetailsActions {
        fun initializeData()

        fun deleteAndExit(id: Int)

        fun saveAndExit(id: Int, name: String, lastName: String)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        detailsActionsListener = context as DetailsActions?
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.details_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editName = view.findViewById(R.id.editStudentName)
        editLastname = view.findViewById(R.id.editStudentLastname)
        editPhoto = view.findViewById(R.id.editStudentPhoto)
        saveButton = view.findViewById(R.id.studentSaveButton)
        deleteButton = view.findViewById(R.id.studentDeleteButton)

        saveButton!!.setOnClickListener { _ ->
            detailsActionsListener!!
                    .saveAndExit(localId, editName!!.text.toString(), editLastname!!.text.toString())
        }
        deleteButton!!.setOnClickListener { _ -> detailsActionsListener!!.deleteAndExit(localId) }

        detailsActionsListener!!.initializeData()
    }

    fun initializeData(id: Int) {
        localId=id
        val student = LocalStudentList.instance.list!!.get(localId)
        editName!!.setText(student.NAME)
        editLastname!!.setText(student.LAST_NAME)
        ImageLoaderUtil.loadImage(editPhoto, student.PHOTO_URL)
    }
}