package com.example.artexplore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class PertunjukanActivity extends AppCompatActivity {
    private RecyclerView rvCategory2;
    private ArrayList<Pertunjukan> list = new ArrayList<>();
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;
    String daerah;
    String lokasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertunjukan);

        rvCategory2 = findViewById(R.id.rv_category2);
        rvCategory2.setHasFixedSize(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        if (getIntent().getStringExtra("daerah") != null){
            daerah = intent.getStringExtra("daerah");
        }

        if (getIntent().getStringExtra("lokasi") != null){
            lokasi = intent.getStringExtra("lokasi");
        }

        if (savedInstanceState == null) {
            setActionBarTitle("Daftar Pertunjukan");
            if(daerah != null){
                for (int i=0; i<PertunjukanData.getListData().size();i++){
                    if (PertunjukanData.getListData().get(i).getDaerah().equals(daerah)){
                        list.add(PertunjukanData.getListData().get(i));
                    }
                }

            }else if(lokasi != null) {
                for(int i=0; i<PertunjukanData.getListData().size();i++){
                    if (PertunjukanData.getListData().get(i).getLokasi().equals(lokasi)){
                        list.add(PertunjukanData.getListData().get(i));
                    }
                }
            }else {
                list.addAll(PertunjukanData.getListData());
            }




            showRecyclerCard();
            mode = R.id.nav_pertunjukan;
        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Pertunjukan> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);

            list.addAll(stateList);
        }

    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    private void showRecyclerCard(){
        rvCategory2.setLayoutManager(new LinearLayoutManager(this));
        PertunjukanAdapter pertunjukanAdapter = new PertunjukanAdapter(this);
        pertunjukanAdapter.setListPertunjukan(list);
        rvCategory2.setAdapter(pertunjukanAdapter);


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
