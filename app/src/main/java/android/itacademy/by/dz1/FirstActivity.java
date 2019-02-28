package android.itacademy.by.dz1;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.itacademy.by.menu.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class FirstActivity extends Activity implements View.OnClickListener {

    private TextView tv1;
    private TextView tv2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);


        Button button = findViewById(R.id.btn);
        button.setOnClickListener(this);

        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTextBackground();
            }
        };

        tv1.setOnClickListener(ocl);

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTextBackground();
            }
        });
    }

    public void changeTextBackground() {

        String tempText = tv1.getText().toString();
        tv1.setText(tv2.getText());
        tv2.setText(tempText);
        Drawable backgroundTemp = tv1.getBackground();
        tv1.setBackground(tv2.getBackground());
        tv2.setBackground(backgroundTemp);
    }

    @Override
    public void onClick(View v) {
        changeTextBackground();
    }
}
