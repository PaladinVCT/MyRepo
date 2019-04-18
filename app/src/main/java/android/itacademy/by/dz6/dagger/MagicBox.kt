package android.itacademy.by.dz6.dagger

import android.itacademy.by.dz6.student.Catalogue
import dagger.Component

@Component(modules = arrayOf(MagicBoxModule::class))

interface MagicBox {
    fun provideCatalogue(): Catalogue
}