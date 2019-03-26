package android.itacademy.by.dz6.fragments;

import android.content.Context;
import android.itacademy.by.dz6.recycle.ImageLoaderUtil;
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

//    public static DetailsFragment newInstance(int id, String name, String lastName, String photoUrl) {
//        DetailsFragment detailsFragment = new DetailsFragment();
//        Bundle args = new Bundle();
//        args.putInt("ID", id);
//        args.putString("NAME", name);
//        args.putString("LASTNAME", lastName);
//        args.putString("PHOTO", photoUrl);
//        detailsFragment.setArguments(args);
//        return detailsFragment;
//    }


    public interface onSavePressed {
        public void saveAndExit(int id, String name, String lastName);
    }

    public interface onDeletePressed {
        public void deleteAndExit(int id);
    }

    public interface onDataInitialize{
        public void initializeData();
    }

    onSavePressed onSaveActivityListener;
    onDeletePressed onDeleteActivityListener;
    onDataInitialize onDataInitializeListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onSaveActivityListener = (onSavePressed) context;
        onDeleteActivityListener = (onDeletePressed) context;
        onDataInitializeListener = (onDataInitialize)context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_layout, container, false);
        return view;
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
                onSaveActivityListener
                        .saveAndExit(id, editName.getText().toString(), editLastname.getText().toString());
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDeleteActivityListener.deleteAndExit(id);
            }
        });

        onDataInitializeListener.initializeData();
    }

    public void initializeData(int id, String name, String lastName, String photoUrl) {
        this.id = id;
        editName.setText(name);
        editLastname.setText(lastName);
        ImageLoaderUtil.loadImage(editPhoto, photoUrl);

    }

}
