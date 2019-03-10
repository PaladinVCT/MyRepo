package android.itacademy.by.dz4;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.itacademy.by.menu.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ClockActivity extends Activity implements View.OnClickListener {
    public static float[] NUMS = new float[3];
    public static boolean CHECK = false;

    private EditText edit1;
    private EditText edit2;
    private EditText edit3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock_layout);
        edit1 = findViewById(R.id.number1);
        edit2 = findViewById(R.id.number2);
        edit3 = findViewById(R.id.number3);
        Button drawDiagramButton = findViewById(R.id.drawDiagramButton);
        drawDiagramButton.setOnClickListener(this);

        ImageView viewSova = findViewById(R.id.clockSova);
        AnimationDrawable animationClock = (AnimationDrawable) viewSova.getBackground();
        animationClock.start();
    }

    @Override
    public void onClick(View v) {
        if (!edit1.getText().toString().equals("") & !edit2.getText().toString().equals("") & !edit3.getText().toString().equals("")) {
            NUMS[0] = Float.valueOf(edit1.getText().toString());
            NUMS[1] = Float.valueOf(edit2.getText().toString());
            NUMS[2] = Float.valueOf(edit3.getText().toString());
            CHECK = true;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back_enter, R.anim.back_exit);
    }
}
