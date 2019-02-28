package android.itacademy.by.dz3;

import android.app.Activity;
import android.itacademy.by.menu.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_activity);
        Button button = findViewById(R.id.getImageButton);
    }

    @Override
    public void onClick(View v) {
        Picasso.with(this)
                .load(findViewById(R.id.urlText).toString())
                .resize(200,200)
                .placeholder(R.drawable.progress)
                .centerCrop()
                .into((ImageView) findViewById(R.id.imageShow));
    }
}
