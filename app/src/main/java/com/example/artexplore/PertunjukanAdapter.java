package com.example.artexplore;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class PertunjukanAdapter extends Adapter<PertunjukanAdapter.CardViewViewHolder>  {
    public PertunjukanAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    public ArrayList<Pertunjukan> getListPertunjukan() {
        return listPertunjukan;
    }

    public void setListPertunjukan(ArrayList<Pertunjukan> listPertunjukan) {
        this.listPertunjukan = listPertunjukan;
    }

    private ArrayList<Pertunjukan> listPertunjukan;

    @NonNull
    @Override
    public PertunjukanAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card_pertunjukan, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PertunjukanAdapter.CardViewViewHolder cardViewViewHolder, final int i) {
        Pertunjukan p = getListPertunjukan().get(i);
        Glide.with(context)
                .load(p.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.imgPhoto);
        cardViewViewHolder.tvJudul.setText(p.getJudul());
        cardViewViewHolder.tvLokasi.setText(p.getLokasi());
        cardViewViewHolder.tvTanggal.setText(p.getTanggal());
        cardViewViewHolder.tvRegular.setText(p.getHarga_reg());
        cardViewViewHolder.tvVIP.setText(p.getHarga_vip());
        cardViewViewHolder.btnDetail.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Detail dari "+getListPertunjukan().get(position).getJudul(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, activity_detail.class);
                intent.putExtra("image_url",getListPertunjukan().get(position).getPhoto());
                intent.putExtra("judul",getListPertunjukan().get(position).getJudul());
                intent.putExtra("lokasi",getListPertunjukan().get(position).getLokasi());
                intent.putExtra("hargaReg",getListPertunjukan().get(position).getHarga_reg());
                intent.putExtra("hargaVip",getListPertunjukan().get(position).getHarga_vip());
                intent.putExtra("desc",getListPertunjukan().get(position).getDeskripsi());
                intent.putExtra("tanggal",getListPertunjukan().get(position).getTanggal());
                context.startActivity(intent);

            }
        }));
        cardViewViewHolder.btnTiket.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Pertunjukan selected = getListPertunjukan().get(position);
                Intent paymentIntent = new Intent(context, PaymentActivity.class);
                paymentIntent.putExtra("nama",selected.getJudul());
                paymentIntent.putExtra("tempat",selected.getLokasi());
                paymentIntent.putExtra("tanggal",selected.getTanggal());
                paymentIntent.putExtra("vip",selected.getHarga_vip());
                paymentIntent.putExtra("reguler",selected.getHarga_reg());
                context.startActivity(paymentIntent);
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListPertunjukan().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgPhoto;
        public TextView tvJudul, tvLokasi, tvTanggal, tvRegular, tvVIP;
        public Button btnDetail, btnTiket;

        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvJudul = itemView.findViewById(R.id.tv_item_judul);
            tvLokasi = itemView.findViewById(R.id.tv_item_lokasi);
            tvTanggal = itemView.findViewById(R.id.tv_item_tanggal);
            tvRegular = itemView.findViewById(R.id.tv_item_regular);
            tvVIP = itemView.findViewById(R.id.tv_item_vip);
            btnDetail = itemView.findViewById(R.id.btn_set_detail);
            btnTiket = itemView.findViewById(R.id.btn_set_pesan);
        }
    }
}
