package android.itacademy.by.cw4;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class cw4Activity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cw4_activity);
        Manager.getInstance().setCw4(this);
    }
}
