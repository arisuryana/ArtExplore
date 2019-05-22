package com.example.artexplore;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String total_harga = prefs.getString("total_harga", null);
        String tempat = prefs.getString("tempat", null);
        String tanggal = prefs.getString("tanggal",null);
        String nama_pembeli = prefs.getString("nama_pembeli",null);
        String email_pembeli = prefs.getString("email_pembeli",null);
        String no_telp = prefs.getString("no_telp",null);
        String jumlah_tiket = prefs.getString("jumlah_tiket",null);
        String jenis = prefs.getString("jenis",null);
        Button clearBooking = findViewById(R.id.clear_button);
        Button homeButton = findViewById(R.id.home_button);
        TextView no_booking = findViewById(R.id.no_item);
        no_booking.setVisibility(View.GONE);

        TextView totalHarga = findViewById(R.id.total_harga);
        TextView tempatView = findViewById(R.id.tempat);
        TextView tanggalView = findViewById(R.id.tanggal);
        TextView namaView = findViewById(R.id.nama_pembeli);
        TextView emailView = findViewById(R.id.email_pembeli);
        TextView telpView = findViewById(R.id.no_telp);
        TextView tiketView = findViewById(R.id.jumlah_tiket);
        TextView jenisView = findViewById(R.id.jenis);
        TextView nama_placeholder = findViewById(R.id.nama_pembeli1);
        TextView email_placeholder = findViewById(R.id.email_pembeli1);
        TextView telp_placeholder = findViewById(R.id.no_telp1);
        TextView jumlah_ticket_placeholder = findViewById(R.id.jumlah_tiket1);
        TextView harga_placeholder = findViewById(R.id.total_harga1);
        TextView tanggal_placeholder = findViewById(R.id.tanggal1);
        TextView tempat_placeholder = findViewById(R.id.tempat1);

        if(tempat == null && tanggal == null && total_harga == null && nama_pembeli == null
        && email_pembeli == null && no_telp == null && jumlah_tiket == null && jenis == null){
            homeButton.setVisibility(View.GONE);
            clearBooking.setVisibility(View.GONE);
            no_booking.setVisibility(View.VISIBLE);
            totalHarga.setVisibility(View.GONE);
            tempatView.setVisibility(View.GONE);
            tanggalView.setVisibility(View.GONE);
            namaView.setVisibility(View.GONE);
            emailView.setVisibility(View.GONE);
            telpView.setVisibility(View.GONE);
            tiketView.setVisibility(View.GONE);
            jenisView.setVisibility(View.GONE);
            nama_placeholder.setVisibility(View.GONE);
            email_placeholder.setVisibility(View.GONE);
            telp_placeholder.setVisibility(View.GONE);
            jumlah_ticket_placeholder.setVisibility(View.GONE);
            harga_placeholder.setVisibility(View.GONE);
            tanggal_placeholder.setVisibility(View.GONE);
            tempat_placeholder.setVisibility(View.GONE);

        } else {
            totalHarga.setText(total_harga);
            tempatView.setText(tempat);
            tanggalView.setText(tanggal);
            namaView.setText(nama_pembeli);
            emailView.setText(email_pembeli);
            telpView.setText(no_telp);
            tiketView.setText(jumlah_tiket);
            jenisView.setText(jenis);

        }

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new  Intent (view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        clearBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PreferenceManager.getDefaultSharedPreferences(view.getContext()).edit().clear().commit();
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
