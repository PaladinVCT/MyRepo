package android.itacademy.by.dz14.handlers

import android.content.Intent
import android.itacademy.by.dz14.activities.DetailsActivity
import android.itacademy.by.dz14.activities.Dz14Activity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View

class ArrowHandler() {

    fun onArrowClick(view: View) {
        val intent = Intent(view.context, Dz14Activity::class.java)
        ContextCompat.startActivity(view.context, intent, Bundle.EMPTY)
    }

}