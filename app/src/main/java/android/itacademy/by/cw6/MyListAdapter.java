package android.itacademy.by.cw6;

import android.itacademy.by.dz6.Student;
import android.itacademy.by.menu.R;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListViewholder> {
    private List<Student> list = new ArrayList<>();
    private OnItemClickListener listener;

    public void setList(List<Student> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyListViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_mylist, viewGroup, false);
final MyListViewholder holder = new MyListViewholder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if(listener!=null){
                    listener.onClick(list.get(position),position);
                }
            }
        });
        return new MyListViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyListViewholder holder, int position) {
        holder.bind(list.get(position), position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnItemClickListener {
        void onClick (Student student, int position);
    }
}
