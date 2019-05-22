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

public class GridDaerahAdapter extends Adapter<GridDaerahAdapter.GridViewHolder> {
    public GridDaerahAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    public ArrayList<Daerah> getListDaerah() {
        return listDaerah;
    }

    public void setListDaerah(ArrayList<Daerah> listDaerah) {
        this.listDaerah = listDaerah;
    }

    private ArrayList<Daerah> listDaerah;

    @NonNull
    @Override
    public GridDaerahAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_daerah, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, final int position) {
        holder.tvName.setText(getListDaerah().get(position).getNama_daerah());
        Glide.with(context)
                .load(getListDaerah().get(position).getPhoto_daerah())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PertunjukanActivity.class);
                intent.putExtra("daerah", getListDaerah().get(position).getNama_daerah());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return getListDaerah().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgPhoto;
        public TextView tvName;

        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.txt_item_name);
        }
    }
}
