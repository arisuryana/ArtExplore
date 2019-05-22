package com.example.artexplore;

import android.os.Parcel;
import android.os.Parcelable;

public class Pertunjukan implements Parcelable {
    private String judul;
    private String daerah;
    private String lokasi;
    private String tanggal;
    private String photo;
    private String harga_reg;
    private String harga_vip;
    private String deskripsi;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDaerah() {
        return daerah;
    }

    public void setDaerah(String daerah) {
        this.daerah = daerah;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getHarga_reg() {
        return harga_reg;
    }

    public void setHarga_reg(String harga_reg) {
        this.harga_reg = harga_reg;
    }

    public String getHarga_vip() {
        return harga_vip;
    }

    public void setHarga_vip(String harga_vip) {
        this.harga_vip = harga_vip;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.daerah);
        dest.writeString(this.lokasi);
        dest.writeString(this.tanggal);
        dest.writeString(this.photo);
        dest.writeString(this.harga_reg);
        dest.writeString(this.harga_vip);
        dest.writeString(this.deskripsi);
    }

    public Pertunjukan(){

    }

    protected Pertunjukan(Parcel in) {
        this.judul = in.readString();
        this.daerah = in.readString();
        this.lokasi = in.readString();
        this.tanggal = in.readString();
        this.photo = in.readString();
        this.harga_reg = in.readString();
        this.harga_vip = in.readString();
        this.deskripsi = in.readString();
    }

    public static final Parcelable.Creator<Pertunjukan> CREATOR = new Creator<Pertunjukan>() {
        @Override
        public Pertunjukan createFromParcel(Parcel in) {
            return new Pertunjukan(in);
        }
        @Override
        public Pertunjukan[] newArray(int size) {
            return new Pertunjukan[size];
        }
    };
}
