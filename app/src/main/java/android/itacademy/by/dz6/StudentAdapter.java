package android.itacademy.by.dz6;

import android.itacademy.by.menu.R;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {


    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_student,viewGroup,false);

        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, int i) {
        studentViewHolder.bind(Catalogue.getInstance().getStudent(i));
    }

    @Override
    public int getItemCount() {
        return Catalogue.getInstance().countStudents();
    }
}
