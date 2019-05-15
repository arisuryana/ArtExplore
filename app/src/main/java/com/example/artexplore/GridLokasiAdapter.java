package com.example.artexplore;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridLokasiAdapter extends Adapter<GridLokasiAdapter.GridViewHolder> {
    public GridLokasiAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    public ArrayList<Lokasi> getListLokasi() {
        return listLokasi;
    }

    public void setListLokasi(ArrayList<Lokasi> listLokasi) {
        this.listLokasi = listLokasi;
    }

    private ArrayList<Lokasi> listLokasi;

    @NonNull
    @Override
    public GridLokasiAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_lokasi, parent, false);
        return new GridLokasiAdapter.GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        holder.tvName.setText(getListLokasi().get(position).getNama_lokasi());
        holder.tvName2.setText(getListLokasi().get(position).getNama_daerah());
        Glide.with(context)
                .load(getListLokasi().get(position).getPhoto_lokasi())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListLokasi().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgPhoto;
        public TextView tvName, tvName2;

        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.txt_item_name);
            tvName2 = itemView.findViewById(R.id.txt_item_name2);
        }
    }
}
