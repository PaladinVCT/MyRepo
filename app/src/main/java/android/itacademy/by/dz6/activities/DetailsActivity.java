package android.itacademy.by.dz6.activities;

import android.content.Intent;
import android.itacademy.by.dz6.fragments.DetailsFragment;
import android.itacademy.by.menu.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity
        implements DetailsFragment.DetailsActions {
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity_layout);

        intent = getIntent();

        DetailsFragment detailsFragment = new DetailsFragment();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.detailsSinglePan, detailsFragment);

        ft.commit();
    }

    @Override
    public void deleteAndExit(int id) {
//        LocalStudentList.getInstance().deleteStudent(id);
        onBackPressed();
    }

    @Override
    public void saveAndExit(int id, String name, String lastName) {
//        LocalStudentList.getInstance().getStudent(id).setFirstName(name);
//        LocalStudentList.getInstance().getStudent(id).setLastName(lastName);
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void initializeData() {
        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.detailsSinglePan);
        if (detailsFragment != null) {
            detailsFragment.initializeData(intent.getIntExtra("ID", 0));
        }
    }
}