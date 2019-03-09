package android.itacademy.by.cw6;

import android.itacademy.by.menu.R;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListViewholder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView textView;

    public MyListViewholder(@NonNull View itemView) {

        super(itemView);
        imageView = itemView.findViewById(R.id.imageViewStudent);
        textView = itemView.findViewById(R.id.textViewStudent);
    }

    public void bind(Student item, int position) {
        ImageLoaderUtil.cancelloadImage(imageView);

        if (TextUtils.isEmpty(item.getUrlImage())) {
            ImageLoaderUtil.loadImage(imageView, item.getUrlImage());
        } else {
            imageView.setImageDrawable(null);
        }

        if (item.getName() != null) {
            textView.setText(item.getName());
        } else {
            textView.setText("");
        }
    }
}
