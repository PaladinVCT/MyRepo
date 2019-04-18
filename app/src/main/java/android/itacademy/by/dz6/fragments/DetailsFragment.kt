package android.itacademy.by.dz6.fragments

import android.content.Context
import android.itacademy.by.dz6.dagger.DaggerMagicBox
import android.itacademy.by.dz6.imageloader.ImageLoaderUtil
import android.itacademy.by.dz6.student.Catalogue
import android.itacademy.by.menu.R
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import kotlinx.android.synthetic.main.details_layout.*
import javax.inject.Inject

class DetailsFragment : Fragment() {

    private var editName: EditText? = null
    private var editLastname: EditText? = null
    private var editPhoto: ImageView? = null
    private var saveButton: Button? = null
    private var deleteButton: Button? = null
    private var id1=0

    private var detailsActionsListener: DetailsActions? = null
    @Inject
    lateinit var catalogue: Catalogue

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

        val component = DaggerMagicBox.builder().build()
        catalogue = component.provideCatalogue()

        editName = view.findViewById(R.id.editStudentName)
        editLastname = view.findViewById(R.id.editStudentLastname)
        editPhoto = view.findViewById(R.id.editStudentPhoto)
        saveButton = view.findViewById(R.id.studentSaveButton)
        deleteButton = view.findViewById(R.id.studentDeleteButton)

        saveButton!!.setOnClickListener { v ->
            detailsActionsListener!!
                    .saveAndExit(id1, editName!!.text.toString(), editLastname!!.text.toString())
        }
        deleteButton!!.setOnClickListener { v -> detailsActionsListener!!.deleteAndExit(id1) }

        detailsActionsListener!!.initializeData()
    }

    fun initializeData(id: Int) {
        this.id1 = id
        val student = catalogue.list.get(id)
        editStudentName.setText(student.firstName)
        editStudentLastname.setText(student.lastName)
        ImageLoaderUtil.loadImage(editStudentPhoto, student.textUrl.toString())
    }
}