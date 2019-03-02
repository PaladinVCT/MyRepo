package android.itacademy.by.dz3;

import android.app.Activity;
import android.itacademy.by.menu.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class ImageActivity extends Activity implements View.OnClickListener {
    private ImageView image;
    private EditText url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_activity);
        Button button = findViewById(R.id.getImageButton);
        button.setOnClickListener(this);
        image = findViewById(R.id.imageShow);
        url = findViewById(R.id.urlText);
    }

    @Override
    public void onClick(View v) {
        String textLink;
        if (url.getText().toString().equals("")) {
            textLink = "https://366days.ru/media/article_images/760/CjvM8AP2-6E.jpg";
        } else textLink = url.getText().toString();
        Picasso.with(this)
                .load(textLink)
                .resize(640, 640)
                .placeholder(R.drawable.progress)
                .error(R.mipmap.ic_launcher_round)
                .centerCrop()
                .transform(new CropCircleTransformation())
                .into(image);
    }
}
