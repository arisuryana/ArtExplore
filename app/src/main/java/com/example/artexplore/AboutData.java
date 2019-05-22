package com.example.artexplore;

import java.util.ArrayList;

public class AboutData {
    public static String[][] data = new String[][]{
            {"Ari Suryana","1705551025",""},
            {"Oka Ananta","1705551029",""},
            {"Yoga Pramesia","1705551030",""},
            {"Bagus Prasetyo","1705551000",""},
    };

    public static ArrayList<About> getListData(){
        About about = null;
        ArrayList<About> list = new ArrayList<>();
        for (String[] aData : data) {
            about = new About();
            about.setNama_anggota(aData[0]);
            about.setNim_anggota(aData[1]);
            about.setPhoto_anggota(aData[2]);

            list.add(about);
        }

        return list;
    }
}
