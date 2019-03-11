package android.itacademy.by.dz6;

import android.app.Activity;
import android.content.Intent;
import android.itacademy.by.menu.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class dz6Activity extends Activity implements View.OnClickListener {
    private RecyclerView rView;
    private StudentAdapter adapter = new StudentAdapter();
    private FloatingActionButton fab;
    private EditText search;
    private List<Student> catalogueCopy = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dz6_layout);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);
        fab.setAlpha(0.5f);
        rView = findViewById(R.id.recyclerDz6);
        rView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rView.setLayoutManager(linearLayoutManager);
        rView.setAdapter(adapter);
        overridePendingTransition(R.anim.entering, R.anim.exiting);

        search = findViewById(R.id.editTextSearch);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
        for (int i = 0; i < Catalogue.getInstance().countStudents(); i++) {
            catalogueCopy.add(Catalogue.getInstance().getStudent(i));
        }
    }

    private void filter(String text) {
        ArrayList<Student> filteredList = new ArrayList<>();
        ArrayList<Student> originalList = new ArrayList<>();
        for (int i = 0; i < Catalogue.getInstance().countStudents(); i++) {
            originalList.add(Catalogue.getInstance().getStudent(i));
        }
        if (!TextUtils.isEmpty(text)) {
            for (Student student : originalList) {
                if (student.getFirstName().toLowerCase().contains(text.toLowerCase())
                        || student.getLastName().toLowerCase().contains(text.toLowerCase())) {
                    filteredList.add(student);
                }
            }
        } else filteredList.addAll(catalogueCopy);
        adapter.filterList(filteredList);

    }

    @Override
    protected void onResume() {
        adapter.notifyDataSetChanged();
        super.onResume();
    }

    @Override
    protected void onPause() {
        adapter.notifyDataSetChanged();
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, CreateStudentActivity.class);
        startActivity(intent);
    }
}
