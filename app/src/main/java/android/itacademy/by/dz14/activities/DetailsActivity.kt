package android.itacademy.by.dz14.activities

import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.itacademy.by.dz14.entity.Person
import android.itacademy.by.dz14.entity.sex
import android.itacademy.by.dz14.viewmodel.PersonViewModel
import android.itacademy.by.menu.BR
import android.itacademy.by.menu.R
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import okhttp3.internal.Internal


class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(android.itacademy.by.menu.R.layout.person_details_layout)
        val num = intent.getIntExtra("ID", 0)
        val person = PersonViewModel().list.get(num)

        val binding = DataBindingUtil.setContentView<ViewDataBinding>(this, R.layout.person_details_layout)
        binding.setVariable(BR.person, person)
        binding.executePendingBindings()
    }
}