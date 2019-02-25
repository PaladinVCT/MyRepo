package android.itacademy.by.DZ1;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class FirstActivity extends Activity implements View.OnClickListener {
    final TextView textView1 = findViewById(R.id.textView1);
    final TextView textView2 = findViewById(R.id.textView2);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button button = findViewById(R.id.btn);
        button.setOnClickListener(this);

        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTextBackground(textView1, textView2);
            }
        };

        textView1.setOnClickListener(ocl);

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTextBackground(textView1, textView2);
            }
        });
    }

    @Override
    public void onClick(View v) {
        changeTextBackground(textView1, textView2);
    }

    public void changeTextBackground(TextView textView1, TextView textView2) {
        String tempText = textView1.getText().toString();
        textView1.setText(textView2.getText());
        textView2.setText(tempText);
        Drawable backgroundTemp = textView1.getBackground();
        textView1.setBackground(textView2.getBackground());
        textView2.setBackground(backgroundTemp);
    }
}
