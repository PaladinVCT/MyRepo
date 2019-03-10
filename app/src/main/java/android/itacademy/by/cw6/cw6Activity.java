package android.itacademy.by.cw6;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.itacademy.by.dz6.Student;
import android.itacademy.by.menu.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class cw6Activity extends Activity {

    private SharedPreferences sharedPreferences;
    private static final String NAME_EXTRA = "NAME_EXTRA";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cw6_layout);

        sharedPreferences = getSharedPreferences("aaa", Context.MODE_PRIVATE);


        final RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
//        recyclerView.addItemDecoration(); сделать отступы, наследоваться от decoration

        List<Student> list = new ArrayList<>();

        MyListAdapter adapter = new MyListAdapter();
        adapter.setList(list);

        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sharedPreferences.edit().putLong(NAME_EXTRA, System.currentTimeMillis()).apply();

    }

    @Override
    protected void onResume() {
        super.onResume();
        long data = sharedPreferences.getLong(NAME_EXTRA, 0);
        Toast.makeText(this, String.valueOf(data), Toast.LENGTH_LONG).show();
    }
}