package android.itacademy.by.dz6.recycle;

import android.content.Context;
import android.itacademy.by.dz6.student.Catalogue;
import android.itacademy.by.dz6.student.Student;
import android.itacademy.by.menu.R;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    private Context context;

    public StudentAdapter(Context context) {
        this.context = context;
    }

    public interface onItemClickListener {
        public void onItemClick(int id, String name, String lastName, String photoUrl);
    }

    onItemClickListener mainActivityListener;

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mainActivityListener = (onItemClickListener) context;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_student, viewGroup, false);
        final StudentViewHolder holder = new StudentViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityListener.onItemClick(holder.getAdapterPosition(),
                        Catalogue.getInstance().getStudent(holder.getAdapterPosition()).getFirstName(),
                        Catalogue.getInstance().getStudent(holder.getAdapterPosition()).getLastName(),
                        Catalogue.getInstance().getStudent(holder.getAdapterPosition()).getTextUrl());


            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, int Id) {
        studentViewHolder.bind(Catalogue.getInstance().getStudent(Id));

    }

    @Override
    public int getItemCount() {
        return Catalogue.getInstance().countStudents();
    }

    public void filterList(ArrayList<Student> filteredList) {
        Catalogue.getInstance().getFullList().clear();
        Catalogue.getInstance().getFullList().addAll(filteredList);
        notifyDataSetChanged();
    }
}
