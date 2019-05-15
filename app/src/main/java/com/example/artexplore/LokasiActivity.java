package com.example.artexplore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class LokasiActivity extends AppCompatActivity {
    private RecyclerView rvCategory1;
    private ArrayList<Lokasi> list = new ArrayList<>();
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lokasi);

        rvCategory1 = findViewById(R.id.rv_category1);
        rvCategory1.setHasFixedSize(true);

        if (savedInstanceState == null) {
            setActionBarTitle("Lokasi Pertunjukan");
            list.addAll(LokasiData.getListData());
            showRecyclerGrid();
            mode = R.id.nav_lokasi;
        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Lokasi> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            list.addAll(stateList);
        }
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    private void showRecyclerGrid(){
        rvCategory1.setLayoutManager(new GridLayoutManager(this, 1));
        GridLokasiAdapter gridLokasiAdapter = new GridLokasiAdapter(this);
        gridLokasiAdapter.setListLokasi(list);
        rvCategory1.setAdapter(gridLokasiAdapter);

        ItemClickSupport.addTo(rvCategory1).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedLokasi(list.get(position));
            }
        });
    }

    private void showSelectedLokasi(Lokasi lokasi) {
        Toast.makeText(this, "Kamu memilih Lokasi " + lokasi.getNama_lokasi(), Toast.LENGTH_SHORT).show();
    }

}
