package com.example.artexplore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class DaerahActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Daerah> list = new ArrayList<>();
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daerah);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        if (savedInstanceState == null) {
            setActionBarTitle("Daerah Pertunjukan");
            list.addAll(DaerahData.getListData());
            showRecyclerGrid();
            mode = R.id.nav_pertunjukan;
        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Daerah> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            list.addAll(stateList);
        }

    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    private void showRecyclerGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(this, 1));
        GridDaerahAdapter gridDaerahAdapter = new GridDaerahAdapter(this);
        gridDaerahAdapter.setListDaerah(list);
        rvCategory.setAdapter(gridDaerahAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedPresident(list.get(position));
            }
        });
    }

    private void showSelectedPresident(Daerah daerah) {
        Toast.makeText(this, "Kamu memilih " + daerah.getNama_daerah(), Toast.LENGTH_SHORT).show();
    }
}
