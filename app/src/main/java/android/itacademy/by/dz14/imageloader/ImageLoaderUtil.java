package android.itacademy.by.dz14.imageloader;

import android.itacademy.by.menu.R;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageLoaderUtil {
    public static void loadImage(ImageView imageView, String url) {

        Picasso.get()
                .load(url)
                .placeholder(R.drawable.progress)
                .error(R.drawable.inset_oval)
                .into(imageView);
    }
}