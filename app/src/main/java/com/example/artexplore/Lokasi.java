package com.example.artexplore;

import android.os.Parcel;
import android.os.Parcelable;

public class Lokasi implements Parcelable {
    private String nama_lokasi;
    private String nama_daerah;
    private String photo_lokasi;

    public String getNama_lokasi() {
        return nama_lokasi;
    }

    public void setNama_lokasi(String nama_lokasi) {
        this.nama_lokasi = nama_lokasi;
    }

    public String getNama_daerah() {
        return nama_daerah;
    }

    public void setNama_daerah(String nama_daerah) {
        this.nama_daerah = nama_daerah;
    }

    public String getPhoto_lokasi() {
        return photo_lokasi;
    }

    public void setPhoto_lokasi(String photo_lokasi) {
        this.photo_lokasi = photo_lokasi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama_lokasi);
        dest.writeString(this.nama_daerah);
        dest.writeString(this.photo_lokasi);
    }

    public Lokasi(){

    }

    protected Lokasi(Parcel in) {
        this.nama_lokasi = in.readString();
        this.nama_daerah = in.readString();
        this.photo_lokasi = in.readString();
    }

    public static final Parcelable.Creator<Lokasi> CREATOR = new Creator<Lokasi>() {
        @Override
        public Lokasi createFromParcel(Parcel in) {
            return new Lokasi(in);
        }
        @Override
        public Lokasi[] newArray(int size) {
            return new Lokasi[size];
        }
    };
}
