package com.dev.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;
import com.dev.myapplication.DataModel;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    List list;
    ProgrammingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<DataModel>();

        addRecyclerViewItem("Amir", R.drawable.amir);
        addRecyclerViewItem("Zeerak", R.drawable.amir);
        addRecyclerViewItem("Amir", R.drawable.amir);
        addRecyclerViewItem("Amir", R.drawable.amir);
        addRecyclerViewItem("Amir", R.drawable.amir);
        addRecyclerViewItem("Amir", R.drawable.amir);

        RecyclerView programmingList = findViewById(R.id.programmingList);
        programmingList.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ProgrammingAdapter(list);
        programmingList.setAdapter(adapter);

    }


    public void addRecyclerViewItem(String name, int img){
        list.add(new DataModel(name,img));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);

        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }


    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        filter(s.toString());
        return true;
    }

    private void filter(String text) {
        ArrayList<DataModel> filteredList = new ArrayList<>();

        for(int position = 0; position < list.size(); position++){
            DataModel dmObj = (DataModel) list.get(position);
            if(dmObj.name.toString().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(dmObj);
            }
        }
        adapter.updateList(filteredList);
    }

}
