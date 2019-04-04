package android.itacademy.by.dz6.activities;

import android.content.Intent;
import android.itacademy.by.dz6.fragments.DetailsFragment;
import android.itacademy.by.dz6.fragments.StudentListFragment;
import android.itacademy.by.dz6.recycle.StudentAdapter;
import android.itacademy.by.dz6.student.Catalogue;
import android.itacademy.by.menu.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements StudentListFragment.OnAddClickListener,
        StudentAdapter.OnItemClickListener,
        DetailsFragment.DetailsActions {

    private boolean dualPan;
    private int id;

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
    public void onItemClick(int id) {

        if (dualPan) {

            DetailsFragment detailsFragment = new DetailsFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragmentDetails, detailsFragment);
            ft.commit();
            this.id = id;

        } else {

            Intent intent = new Intent(this, DetailsActivity.class);
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
        if (detailsFragment != null) {
            detailsFragment.initializeData(id);
        }
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
        StudentListFragment studentListFragment = (StudentListFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentRecycle);
        if (studentListFragment != null) {
            studentListFragment.getAdapter().notifyDataSetChanged();
        }
    }

    public void removeDetailsFragment() {
        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentDetails);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (detailsFragment != null) {
            ft.remove(detailsFragment);
            ft.commit();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeDetailsFragment();
    }
}