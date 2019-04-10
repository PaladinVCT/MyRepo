package android.itacademy.by.menu;

import android.app.Activity;
import android.content.Intent;
import android.itacademy.by.dz1.FirstActivity;
import android.itacademy.by.dz2.FlagsActivity;
import android.itacademy.by.dz3.ImageActivity;
import android.itacademy.by.dz3.LoginActivity;
import android.itacademy.by.dz4.ClockActivity;
import android.itacademy.by.dz4.SovaActivity;
import android.itacademy.by.dz6.activities.MainActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity implements View.OnClickListener {
    private int[] diagNums = {10, 5, 3};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        Button buttonDz1 = findViewById(R.id.buttonDz1);
        buttonDz1.setOnClickListener(this);
        Button buttonDz2 = findViewById(R.id.buttonDz2);
        buttonDz2.setOnClickListener(this);
        Button buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(this);
        Button buttonDz3 = findViewById(R.id.dz3);
        buttonDz3.setOnClickListener(this);
        Button buttonDz4 = findViewById(R.id.dz4);
        buttonDz4.setOnClickListener(this);
        Button sova = findViewById(R.id.sovaButton);
        sova.setOnClickListener(this);
        Button dz5Button = findViewById(R.id.dz5Button);
        dz5Button.setOnClickListener(this);
        Button dz6Button = findViewById(R.id.dz6Button);
        dz6Button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonDz1: {
                Intent intent = new Intent(this, FirstActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.buttonDz2: {
                Intent intent2 = new Intent(this, FlagsActivity.class);
                startActivity(intent2);
                break;
            }
            case R.id.buttonLogin:
                Intent intent3 = new Intent(this, LoginActivity.class);
                startActivity(intent3);
                break;

            case R.id.dz3:
                Intent intent4 = new Intent(this, ImageActivity.class);
                startActivity(intent4);
                break;
            case R.id.dz4:
                Intent intent5 = new Intent(this, ClockActivity.class);
                startActivity(intent5);
                overridePendingTransition(R.anim.entering, R.anim.exiting);
                break;
            case R.id.sovaButton:
                Intent intent6 = new Intent(this, SovaActivity.class);
                startActivity(intent6);
                overridePendingTransition(R.anim.entering, R.anim.exiting);
                break;
            case R.id.dz6Button:
                Intent intent8 = new Intent(this, MainActivity.class);
                startActivity(intent8);
                overridePendingTransition(R.anim.entering,R.anim.exiting);
                break;
        }
    }
}