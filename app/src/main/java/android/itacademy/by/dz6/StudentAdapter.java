package android.itacademy.by.dz6;

import android.content.Intent;
import android.itacademy.by.menu.R;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {


    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_student,viewGroup,false);
        final StudentViewHolder holder = new StudentViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewGroup.getContext(),EditStudentActivity.class);
                intent.putExtra("NAME",Catalogue.getInstance().getStudent(holder.getAdapterPosition()).getFirstName());
                intent.putExtra("LASTNAME",Catalogue.getInstance().getStudent(holder.getAdapterPosition()).getLastName());
                intent.putExtra("PHOTO",Catalogue.getInstance().getStudent(holder.getAdapterPosition()).getTextUrl());
                intent.putExtra("NUMBER",holder.getAdapterPosition());
                v.getContext().startActivity((intent));

            }
        });
        return holder;
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
