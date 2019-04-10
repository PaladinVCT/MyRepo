package android.itacademy.by.dz6.recycle;

import android.itacademy.by.menu.R;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageLoaderUtil {
    public static void loadImage(ImageView imageView,String url){
//        Picasso.get().load(url).into(imageView);

        Picasso.get()
                .load(url)
                .placeholder(R.drawable.progress)
                .into(imageView);

    }
}