package android.itacademy.by.dz14.activities

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.itacademy.by.dz14.handlers.ArrowHandler
import android.itacademy.by.dz14.viewmodel.PersonViewModel
import android.itacademy.by.menu.BR
import android.itacademy.by.menu.R
import android.os.Bundle
import android.support.v7.app.AppCompatActivity


class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(android.itacademy.by.menu.R.layout.person_details_layout)
        val num = intent.getIntExtra("ID", 0)
        val person = PersonViewModel().list.get(num)
        val handler = ArrowHandler()
        val viewModel = PersonViewModel()

        val binding = DataBindingUtil.setContentView<ViewDataBinding>(this, R.layout.person_details_layout)
        binding.setVariable(BR.person, person)
        binding.setVariable(BR.handler, handler)
        binding.setVariable(BR.viewModel,viewModel)
        binding.executePendingBindings()
    }
}