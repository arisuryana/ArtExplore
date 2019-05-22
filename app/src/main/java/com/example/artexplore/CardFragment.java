package com.example.artexplore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;


public class CardFragment extends Fragment {

    private CardView cardView;
    private ArrayList<Pertunjukan> list = new ArrayList<>();

    public static Fragment getInstance(int position) {
        CardFragment f = new CardFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        f.setArguments(args);

        return f;
    }

    @SuppressLint("DefaultLocale")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.card_item, container, false);
        Context context = view.getContext();
        cardView = view.findViewById(R.id.cardView);
        cardView.setMaxCardElevation(cardView.getCardElevation() * CardAdapter.MAX_ELEVATION_FACTOR);
        list.addAll(PertunjukanData.getListPopular());
        TextView title =  view.findViewById(R.id.title);
        TextView place = view.findViewById(R.id.place);
        TextView desc = view.findViewById(R.id.desc);
        ImageView photo = view.findViewById(R.id.imageView);
        Pertunjukan pertunjukan = list.get(getArguments().getInt("position"));
        String pertunjukanTitle = pertunjukan.getJudul();
        String pertunjukanPlace = pertunjukan.getDaerah();
        String pertunjukanDesc = pertunjukan.getShortDeskripsi();

        title.setText(pertunjukanTitle);
        place.setText(pertunjukanPlace);
        desc.setText(pertunjukanDesc);

        Glide.with(context)
                .load(pertunjukan.getPhoto())
                .into(photo);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(), "Button in Card " + getArguments().getInt("position")
//                        + "Clicked!", Toast.LENGTH_SHORT).show();
//            }
//        });

        return view;
    }

    public CardView getCardView() {
        return cardView;
    }
}