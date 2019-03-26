package android.itacademy.by.dz6.activities;

import android.content.Intent;
import android.itacademy.by.dz6.fragments.RecycleFragment;
import android.itacademy.by.dz6.recycle.StudentAdapter;
import android.itacademy.by.menu.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements RecycleFragment.OnAddClickListener, StudentAdapter.onItemClickListener
{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);


    }

    @Override
    public void startCreateActivity() {
        Intent intent = new Intent(this, CreateActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(int id, String name, String lastName, String photoUrl) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("NAME", name );
        intent.putExtra("LASTNAME",lastName );
        intent.putExtra("PHOTO",photoUrl );
        intent.putExtra("ID", id);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        RecycleFragment recycleFragment = (RecycleFragment)getSupportFragmentManager()
                .findFragmentById(R.id.fragmentRecycle);
        assert recycleFragment != null;
        recycleFragment.getAdapter().notifyDataSetChanged();
    }
}
