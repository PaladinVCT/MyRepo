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

    public interface OnItemClickListener {
        void onItemClick(int id);
    }

    private OnItemClickListener onItemClickListener;

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        onItemClickListener = (OnItemClickListener) context;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_student, viewGroup, false);
        final StudentViewHolder holder = new StudentViewHolder(view);
        view.setOnClickListener(v -> onItemClickListener.onItemClick(holder.getAdapterPosition()));
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