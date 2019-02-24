package android.itacademy.by.login;

import android.app.Activity;
import android.itacademy.by.menu.R;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class LoginActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }
}
