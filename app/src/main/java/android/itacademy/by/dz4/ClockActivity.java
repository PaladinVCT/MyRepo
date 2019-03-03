package android.itacademy.by.dz4;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.itacademy.by.menu.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

public class ClockActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock_layout);
        ImageView viewSova = findViewById(R.id.clockSova);
        AnimationDrawable animationClock= (AnimationDrawable)viewSova.getBackground();
        animationClock.start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back_enter, R.anim.back_exit);
    }

}
