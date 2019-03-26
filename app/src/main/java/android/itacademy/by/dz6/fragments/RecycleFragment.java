package android.itacademy.by.dz6.fragments;

import android.content.Context;
import android.itacademy.by.dz6.recycle.StudentAdapter;
import android.itacademy.by.dz6.student.Catalogue;
import android.itacademy.by.dz6.student.Student;
import android.itacademy.by.menu.R;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class RecycleFragment extends Fragment {

    boolean dualPane;
    private StudentAdapter adapter;

    public interface OnAddClickListener {
        public void startCreateActivity();
    }

    OnAddClickListener mainActivityListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivityListener = (OnAddClickListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycle_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Student> catalogueCopy = new ArrayList<>();
        adapter = new StudentAdapter(view.getContext());

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityListener.startCreateActivity();
            }
        });
        fab.setAlpha(0.6f);
        RecyclerView rView = view.findViewById(R.id.recyclerDz6);
        rView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        rView.setLayoutManager(linearLayoutManager);
        rView.setAdapter(adapter);

        EditText search = view.findViewById(R.id.editTextSearch);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
//                filter(s.toString());
            }
        });

        for (int i = 0; i < Catalogue.getInstance().countStudents(); i++) {
            catalogueCopy.add(Catalogue.getInstance().getStudent(i));
        }
    }
    public StudentAdapter getAdapter(){
        return adapter;
    }
}


//    private void filter(String text) {
//        ArrayList<Student> filteredList = new ArrayList<>();
//        ArrayList<Student> originalList = new ArrayList<>();
//        for (int i = 0; i < Catalogue.getInstance().countStudents(); i++) {
//            originalList.add(Catalogue.getInstance().getStudent(i));
//        }
//        if (!TextUtils.isEmpty(text)) {
//            for (Student student : originalList) {
//                if (student.getFirstName().toLowerCase().contains(text.toLowerCase())
//                        || student.getLastName().toLowerCase().contains(text.toLowerCase())) {
//                    filteredList.add(student);
//                }
//            }
//        } else filteredList.addAll(catalogueCopy);
//        adapter.filterList(filteredList);
//
//    }

//    @Override
//    protected void onResume() {
//        catalogueCopy.clear();
//
//        for (int i = 0; i < Catalogue.getInstance().countStudents(); i++) {
//            catalogueCopy.add(Catalogue.getInstance().getStudent(i));
//        }
//
//        adapter.notifyDataSetChanged();
//        super.onResume();
//    }
//
//    @Override
//    protected void onPause() {
//        adapter.notifyDataSetChanged();
//        super.onPause();
//    }




