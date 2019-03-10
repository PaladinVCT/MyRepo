package android.itacademy.by.dz6;

import android.app.Activity;
import android.itacademy.by.menu.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class dz6Activity extends Activity {
    private RecyclerView rView;
    private StudentAdapter adapter = new StudentAdapter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dz6_layout);
        rView = findViewById(R.id.recyclerDz6);
        rView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rView.setLayoutManager(linearLayoutManager);
        rView.setAdapter(adapter);
        overridePendingTransition(R.anim.entering, R.anim.exiting);
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
}
