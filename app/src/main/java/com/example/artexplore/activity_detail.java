package com.example.artexplore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class activity_detail extends AppCompatActivity {
    public static final String EXTRA_PHOTO = "image_url";
    public static final String EXTRA_JUDUL = "judul";
    public static final String EXTRA_LOKASI = "lokasi";
    public static final String EXTRA_HARGAREG = "hargaReg";
    public static final String EXTRA_HARGAVIP = "hargaVip";
    public static final String EXTRA_DESKRIPSI = "desc";
    public static final String EXTRA_TANGGAL = "tanggal";
    TextView tv_desc;
    ImageView tv_photos;
    TextView tv_judul;
    TextView tv_lokasi;
    TextView tv_harga_reg;
    TextView tv_harga_vip;
    TextView tv_tanggal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tv_photos = findViewById(R.id.image_det);
        tv_judul = findViewById(R.id.judul);
        tv_lokasi = findViewById(R.id.lokasi);
        tv_harga_reg = findViewById(R.id.hargareguler2);
        tv_harga_vip = findViewById(R.id.hargaVIP2);
        tv_desc = findViewById(R.id.deskripsi);
        tv_tanggal = findViewById(R.id.tanggal);

        String foto = getIntent().getStringExtra(EXTRA_PHOTO);
        String judul = getIntent().getStringExtra(EXTRA_JUDUL);
        String lokasi = getIntent().getStringExtra(EXTRA_LOKASI);
        String hargareg = getIntent().getStringExtra(EXTRA_HARGAREG);
        String hargavip = getIntent().getStringExtra(EXTRA_HARGAVIP);
        String deskripsi = getIntent().getStringExtra(EXTRA_DESKRIPSI);
        String tanggal = getIntent().getStringExtra(EXTRA_TANGGAL);

        namaactionbar(judul);

        tv_desc.setText(deskripsi);
        tv_judul.setText(judul);
        tv_lokasi.setText(lokasi);
        tv_harga_reg.setText(hargareg);
        tv_harga_vip.setText(hargavip);
        tv_tanggal.setText(tanggal);

        Glide.with(getBaseContext())
                .load(foto)
                .apply(new RequestOptions().override(500,650))
                .into(tv_photos);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void namaactionbar(String title){
        getSupportActionBar().setTitle(title);
    }

}
