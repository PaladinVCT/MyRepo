package android.itacademy.by.dz6.fragments;

import android.content.Context;
import android.itacademy.by.dz6.recycle.ImageLoaderUtil;
import android.itacademy.by.dz6.student.Catalogue;
import android.itacademy.by.dz6.student.Student;
import android.itacademy.by.menu.R;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class DetailsFragment extends Fragment {

    private EditText editName;
    private EditText editLastname;
    private ImageView editPhoto;
    private Button saveButton;
    private Button deleteButton;
    private int id;

    public interface DetailsActions {
        void initializeData();

        void deleteAndExit(int id);

        void saveAndExit(int id, String name, String lastName);
    }

    DetailsActions ActivityListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ActivityListener = (DetailsActions) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.details_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editName = view.findViewById(R.id.editStudentName);
        editLastname = view.findViewById(R.id.editStudentLastname);
        editPhoto = view.findViewById(R.id.editStudentPhoto);
        saveButton = view.findViewById(R.id.studentSaveButton);
        deleteButton = view.findViewById(R.id.studentDeleteButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityListener
                        .saveAndExit(id, editName.getText().toString(), editLastname.getText().toString());
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityListener.deleteAndExit(id);
            }
        });

        ActivityListener.initializeData();
    }

    public void initializeData(int id) {
        this.id = id;
        Student student = Catalogue.getInstance().getStudent(id);
        editName.setText(student.getFirstName());
        editLastname.setText(student.getLastName());
        ImageLoaderUtil.loadImage(editPhoto, student.getTextUrl());
    }
}