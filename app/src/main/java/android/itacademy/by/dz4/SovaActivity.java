package android.itacademy.by.dz4;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.itacademy.by.menu.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

public class SovaActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sova_layout);
        ImageView view = findViewById(R.id.sovaView);
        AnimationDrawable sovaAnimation = (AnimationDrawable)view.getBackground();
        sovaAnimation.start();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back_enter, R.anim.back_exit);
    }
}
