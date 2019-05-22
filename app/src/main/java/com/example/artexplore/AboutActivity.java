package com.example.artexplore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class AboutActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<About> list = new ArrayList<>();
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        rvCategory = findViewById(R.id.rv_category3);
        rvCategory.setHasFixedSize(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        if (savedInstanceState == null) {
            setActionBarTitle("About Us");
            list.addAll(AboutData.getListData());
            showRecyclerGrid();
            mode = R.id.nav_about;
        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<About> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            list.addAll(stateList);
        }
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    private void showRecyclerGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        AboutAdapter gridAboutAdapter = new AboutAdapter(this);
        gridAboutAdapter.setListAbout(list);
        rvCategory.setAdapter(gridAboutAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedAbout(list.get(position));
            }
        });
    }

    private void showSelectedAbout(About about) {
        Toast.makeText(this, about.getNama_anggota(), Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
