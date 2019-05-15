package com.example.artexplore;

import java.util.ArrayList;

public class LokasiData {
    public static String[][] data = new String[][]{
            {"Amfiteater Pura Uluwatu", "Kuta Selatan, Bali", "https://3.bp.blogspot.com/-4MBpW3M3PVY/WBRlouTBmYI/AAAAAAAAN2w/XWpDjue2-c4CzzecFvkBT1-fGS7CvDLsQCLcB/s1600/DSCN6291.JPG"},
            {"Teater Bali Nusa Dua", "Nusa Dua ITDC, Bali", "https://www.devdanshow.com/booking/assets/images/seat/vip-seats-172102.jpg"},
            {"Museum ARMA", "Ubud, Gianyar", "https://awsimages.detik.net.id/community/media/visual/2017/06/25/03161559-6790-4382-abc5-498750e2975a_169.jpg?w=620"},
            {"Garuda Wisnu Kencana", "Kuta Selatan, Bali", "http://4.bp.blogspot.com/-IjfdicogVuA/Vgk9pSU2sAI/AAAAAAAABRo/I4RodpdPSfs/s1600/amphitheatercopy.jpg"},
            {"Taman Budaya NTB", "Lombok, NTB", "https://matramantra.files.wordpress.com/2013/05/ntb.jpg"},
            {"Pantai Seger", "Lombok, NTB", "https://phinemo.com/wp-content/uploads/2018/04/Pemandangan-yang-tenang-dari-Pantai-Kuta-bagian-dari-kawasan-wisata-Mandalika-di-Lombok-Nusa-Tenggara-Barat@Shutterstock.jpg"},
            {"Desa Sade", "Lombok, NTB", "https://2.bp.blogspot.com/-ueqCFn10mIo/WI7M3eAMWhI/AAAAAAAAF94/9nWFIMM-TlEC1_9kDyfdbpzZHvvKcI4qwCLcB/s1600/_MG_1386.JPG"},
            {"Panggung Terbuka Prambanan", "Candi Prambanan, Yogyakarta", "http://resources.mynewsdesk.com/image/upload/t_limit_1000/uz1qth8pfuige8nofpul.jpg"},
            {"Museum Senobudoyo", "Daerah Istimewa Yogyakarta", "http://wargajogja.net/wp-content/uploads/2017/09/IMG_0246-3-1024x683.jpg"},
            {"Candi Borobudur", "Magelang, Yogyakarta", "https://alaransel.com/wp-content/uploads/2012/11/JOGJA-PACKAGE-TOUR.jpg"},
    };

    public static ArrayList<Lokasi> getListData(){
        Lokasi lokasi = null;
        ArrayList<Lokasi> list = new ArrayList<>();
        for (String[] aData : data) {
            lokasi = new Lokasi();
            lokasi.setNama_lokasi(aData[0]);
            lokasi.setNama_daerah(aData[1]);
            lokasi.setPhoto_lokasi(aData[2]);

            list.add(lokasi);
        }

        return list;
    }
}
