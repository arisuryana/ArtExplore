package com.example.artexplore;

import java.util.ArrayList;

public class AboutData {
    public static String[][] data = new String[][]{
            {"Ari Suryana","1705551025","https://i.ibb.co/WD7NV0x/photo-2019-05-21-17-03-37.jpg"},
            {"Oka Ananta","1705551029","https://i.ibb.co/G5B2Zw9/DSC08675.jpg"},
            {"Yoga Pramesia","1705551030","https://i.ibb.co/sQL0jkk/25679.jpg"},
            {"Bagus Prasetyo","1705551050","https://i.ibb.co/syNXGNf/Screenshot-2.png"},
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
