package com.example.artexplore;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class PaymentActivity extends AppCompatActivity {
    Integer ticketPrice;
    String ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        Log.w("myApp","test");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setContentView(R.layout.activity_payment);
        if (extras != null) {
            String nama = extras.getString("nama");
            final String tempat = extras.getString("tempat");
            final String tanggal = extras.getString("tanggal");
            final String vip = extras.getString("vip");
            final String reg = extras.getString("reguler");
            TextView namaPertunjukan = findViewById(R.id.nama);
            TextView tempatPertunjukan = findViewById(R.id.tempat);
            TextView tanggalPertunjukan = findViewById(R.id.tanggal);
            RadioButton buttonVip = findViewById(R.id.vip);
            RadioButton buttonReg = findViewById(R.id.regular);
            Button submitButton = findViewById(R.id.button);
            RadioGroup radioGroup = findViewById(R.id.radioGroup1);

            namaPertunjukan.setText(nama);
            tempatPertunjukan.setText(tempat);
            tanggalPertunjukan.setText(tanggal);
            buttonVip.setText(String.format("VIP Ticket\n(IDR %,d)",Integer.parseInt(vip)));
            buttonReg.setText(String.format("Regular Ticket\n(IDR %,d)",
                    Integer.parseInt(reg)));

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId) {
                        case R.id.vip:
                            ticketPrice = Integer.parseInt(vip);
                            ticket = String.format("Vip(IDR %,d)",Integer.parseInt(vip));
                            break;
                        case R.id.regular:
                            ticketPrice = Integer.parseInt(reg);
                            ticket = String.format("Regular(IDR %,d)",Integer.parseInt(reg));
                            break;
                    }
                }
            });

            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText jumlahTiket = findViewById(R.id.jumlah_tiket);
                    EditText namaPembeli = findViewById(R.id.nama_pembeli);
                    EditText emailPembeli = findViewById(R.id.email_pembeli);
                    EditText noTelp = findViewById(R.id.no_telp);
                    Context context = view.getContext();
                    String totalHarga =
                            Integer.toString(Integer.parseInt(jumlahTiket.getText().toString()) * ticketPrice);
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("nama_pembeli",namaPembeli.getText().toString());
                    editor.putString("email_pembeli",emailPembeli.getText().toString());
                    editor.putString("no_telp",noTelp.getText().toString());
                    editor.putString("jumlah_tiket",jumlahTiket.getText().toString());
                    editor.putString("total_harga",totalHarga);
                    editor.putString("tempat",tempat);
                    editor.putString("tanggal",tanggal);
                    editor.commit();
                    Intent intent = new Intent(context, BookingActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
