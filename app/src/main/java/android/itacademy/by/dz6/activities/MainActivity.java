package android.itacademy.by.dz6.activities;

import android.content.Intent;
import android.itacademy.by.dz6.fragments.DetailsFragment;
import android.itacademy.by.dz6.fragments.RecycleFragment;
import android.itacademy.by.dz6.recycle.StudentAdapter;
import android.itacademy.by.dz6.student.Catalogue;
import android.itacademy.by.dz6.student.Student;
import android.itacademy.by.menu.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements RecycleFragment.OnAddClickListener,
        StudentAdapter.onItemClickListener,
        DetailsFragment.onDataInitialize,
        DetailsFragment.onSavePressed,
        DetailsFragment.onDeletePressed {

    private boolean dualPan;
    private Student detailsStudent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        View detailsFrame = findViewById(R.id.fragmentDetails);
        if (detailsFrame != null) {
            dualPan = true;
        }

    }

    @Override
    public void startCreateActivity() {
        Intent intent = new Intent(this, CreateActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(int id, String name, String lastName, String photoUrl) {

        if (dualPan) {

            DetailsFragment detailsFragment = new DetailsFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.fragmentDetails, detailsFragment);
            ft.commit();
            detailsStudent = putDetailsStudent(id, name, lastName, photoUrl);

        } else {

            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("NAME", name);
            intent.putExtra("LASTNAME", lastName);
            intent.putExtra("PHOTO", photoUrl);
            intent.putExtra("ID", id);
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }

    @Override
    public void initializeData() {
        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentDetails);
        assert detailsFragment != null;
        detailsFragment.initializeData(detailsStudent.getId(),
                detailsStudent.getFirstName(),
                detailsStudent.getLastName(),
                detailsStudent.getTextUrl());
    }

    public Student putDetailsStudent(int id, String name, String lastName, String photoUrl) {
        return new Student(id, name, lastName, photoUrl);
    }

    @Override
    public void saveAndExit(int id, String name, String lastName) {
        Catalogue.getInstance().getStudent(id).setFirstName(name);
        Catalogue.getInstance().getStudent(id).setLastName(lastName);
        removeDetailsFragment();
        refresh();
    }

    @Override
    public void deleteAndExit(int id) {
        Catalogue.getInstance().deleteStudent(id);
        removeDetailsFragment();
        refresh();
    }

    public void refresh() {
        RecycleFragment recycleFragment = (RecycleFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentRecycle);
        assert recycleFragment != null;
        recycleFragment.getAdapter().notifyDataSetChanged();
    }

    public void removeDetailsFragment() {
        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentDetails);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        assert detailsFragment != null;
        ft.remove(detailsFragment);
        ft.commit();
    }
}