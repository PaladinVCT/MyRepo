package android.itacademy.by.menu;

import android.app.Activity;
import android.content.Intent;
import android.itacademy.by.dz1.FirstActivity;
import android.itacademy.by.dz2.FlagsActivity;
import android.itacademy.by.dz3.LoginActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity implements View.OnClickListener {
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
        }

    }
}
