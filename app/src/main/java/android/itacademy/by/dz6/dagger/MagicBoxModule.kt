package android.itacademy.by.dz6.dagger

import android.itacademy.by.dz6.student.Catalogue
import dagger.Module
import dagger.Provides


@Module
class MagicBoxModule {

    @Provides
    fun getCatalogueInstance():Catalogue{
        return Catalogue.instance
    }
}