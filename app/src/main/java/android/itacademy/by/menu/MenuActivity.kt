package android.itacademy.by.menu

import android.app.Activity
import android.content.Intent
import android.itacademy.by.dz1.FirstActivity
import android.itacademy.by.dz14.activities.Dz14Activity
import android.itacademy.by.dz2.FlagsActivity
import android.itacademy.by.dz3.ImageActivity
import android.itacademy.by.dz3.LoginActivity
import android.itacademy.by.dz4.ClockActivity
import android.itacademy.by.dz4.SovaActivity
import android.itacademy.by.dz6.activities.MainActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MenuActivity : Activity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)
        val buttonDz1 = findViewById<Button>(R.id.buttonDz1)
        buttonDz1.setOnClickListener(this)
        val buttonDz2 = findViewById<Button>(R.id.buttonDz2)
        buttonDz2.setOnClickListener(this)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        buttonLogin.setOnClickListener(this)
        val buttonDz3 = findViewById<Button>(R.id.dz3)
        buttonDz3.setOnClickListener(this)
        val buttonDz4 = findViewById<Button>(R.id.dz4)
        buttonDz4.setOnClickListener(this)
        val sova = findViewById<Button>(R.id.sovaButton)
        sova.setOnClickListener(this)
        val dz5Button = findViewById<Button>(R.id.dz5Button)
        dz5Button.setOnClickListener(this)
        val dz6Button = findViewById<Button>(R.id.dz6Button)
        dz6Button.setOnClickListener(this)
        val dz7Button = findViewById<Button>(R.id.dz7Button)
        dz7Button.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        when (v.id) {
            R.id.buttonDz1 -> {
                val intent = Intent(this, FirstActivity::class.java)
                startActivity(intent)
            }
            R.id.buttonDz2 -> {
                val intent2 = Intent(this, FlagsActivity::class.java)
                startActivity(intent2)
            }
            R.id.buttonLogin -> {
                val intent3 = Intent(this, LoginActivity::class.java)
                startActivity(intent3)
            }

            R.id.dz3 -> {
                val intent4 = Intent(this, ImageActivity::class.java)
                startActivity(intent4)
            }
            R.id.dz4 -> {
                val intent5 = Intent(this, ClockActivity::class.java)
                startActivity(intent5)
                overridePendingTransition(R.anim.entering, R.anim.exiting)
            }
            R.id.sovaButton -> {
                val intent6 = Intent(this, SovaActivity::class.java)
                startActivity(intent6)
                overridePendingTransition(R.anim.entering, R.anim.exiting)
            }
            R.id.dz6Button -> {
                val intent8 = Intent(this, MainActivity::class.java)
                startActivity(intent8)
                overridePendingTransition(R.anim.entering, R.anim.exiting)
            }
            R.id.dz7Button -> {
                val intent9 = Intent(this, Dz14Activity::class.java)
                startActivity(intent9)
                overridePendingTransition(R.anim.entering, R.anim.exiting)
            }
        }
    }
}