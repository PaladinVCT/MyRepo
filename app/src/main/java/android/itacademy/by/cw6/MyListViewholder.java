package android.itacademy.by.cw6;

import android.itacademy.by.dz6.ImageLoaderUtil;
import android.itacademy.by.dz6.Student;
import android.itacademy.by.menu.R;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
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
        ImageLoaderUtil.cancelLoadImage(imageView);
        if (item.getFirstName() != null) {
            textView.setText(item.getFirstName());
        } else {
            textView.setText("");
        }

    }
}
