package com.example.artexplore;

import android.content.Context;
import android.content.Intent;
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

public class AboutAdapter extends Adapter<AboutAdapter.GridViewHolder>{
    public AboutAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    public ArrayList<About> getListAbout() {
        return listAbout;
    }

    public void setListAbout(ArrayList<About> listAbout) {
        this.listAbout = listAbout;
    }

    private ArrayList<About> listAbout;

    @NonNull
    @Override
    public AboutAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_about, parent, false);
        return new AboutAdapter.GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, final int position) {
        holder.tvName.setText(getListAbout().get(position).getNama_anggota());
        holder.tvNim.setText(getListAbout().get(position).getNim_anggota());
        Glide.with(context)
                .load(getListAbout().get(position).getPhoto_anggota())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListAbout().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgPhoto;
        public TextView tvName, tvNim;

        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.txt_item_name);
            tvNim = itemView.findViewById(R.id.txt_item_nim);
        }
    }
}
