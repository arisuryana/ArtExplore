package com.example.artexplore;

import java.util.ArrayList;

public class DaerahData {
    public static String[][] data = new String[][]{
            {"Bali", "https://www.newszii.com/wp-content/uploads/2018/07/Bali-Indonesia-1024x576.jpg"},
            {"Lombok", "https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2015/05/Blog_Liburan-ke-Lombok-Jangan-Lupa-untuk-Mengunjungi-10-Tempat-Menawan-Ini_825x355px.jpg"},
            {"Yogyakarta", "https://nusantarakaya.com/wp-content/uploads/2018/02/Monumen-Tugu-Khas-Provinsi-DI-Yogyakarta.jpg"},
            {"Surabaya", "https://www.goodnewsfromindonesia.id/uploads/post/large-surabaya-6b40c47198235b9b7d075492a0745ca8.jpg"},
            {"Jakarta", "https://www.dentons.com/-/media/images/website/background-images/offices/jakarta/jakarta-office.jpg"},
            {"Palembang", "https://upload.wikimedia.org/wikipedia/id/5/50/Ampera-baru.jpg"},
    };

    public static ArrayList<Daerah> getListData(){
        Daerah daerah = null;
        ArrayList<Daerah> list = new ArrayList<>();
        for (String[] aData : data) {
            daerah = new Daerah();
            daerah.setNama_daerah(aData[0]);
            daerah.setPhoto_daerah(aData[1]);

            list.add(daerah);
        }

        return list;
    }
}
