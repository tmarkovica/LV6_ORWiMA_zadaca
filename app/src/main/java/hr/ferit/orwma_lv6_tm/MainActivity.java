package hr.ferit.orwma_lv6_tm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NameClickListener {

    private RecyclerView recyclerView;
    private List<String> dataList;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupNames();
        setupRecyclerView();
    }

    private void setupNames() {
        dataList = new ArrayList<>();
        dataList.add("Robin");
        dataList.add("David");
        dataList.add("Filip");
        dataList.add("Petar");
        dataList.add("Laura");
        dataList.add("Mihaela");
        dataList.add("Ana");
        dataList.add("Vlatka");
        dataList.add("Robin2");
        dataList.add("David2");
        dataList.add("Filip2");
        dataList.add("Petar2");
        dataList.add("Laura2");
        dataList.add("Mihaela2");
        dataList.add("Ana2");
        dataList.add("Vlatka2");
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        customAdapter = new CustomAdapter(dataList, this);
        recyclerView.setAdapter(customAdapter);
    }

    @Override
    public void onNameClick(int position) {
        Log.d("onNameClick", "remove name" + dataList.get(position));

        ((CustomAdapter)recyclerView.getAdapter()).removeName(position);
    }
}