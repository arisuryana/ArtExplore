package com.example.artexplore;

import android.os.Parcel;
import android.os.Parcelable;

public class About implements Parcelable {
    private String nama_anggota;
    private String nim_anggota;
    private String photo_anggota;

    public String getNama_anggota() {
        return nama_anggota;
    }

    public void setNama_anggota(String nama_anggota) {
        this.nama_anggota = nama_anggota;
    }

    public String getNim_anggota() {
        return nim_anggota;
    }

    public void setNim_anggota(String nim_anggota) {
        this.nim_anggota = nim_anggota;
    }

    public String getPhoto_anggota() {
        return photo_anggota;
    }

    public void setPhoto_anggota(String photo_anggota) {
        this.photo_anggota = photo_anggota;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama_anggota);
        dest.writeString(this.nim_anggota);
        dest.writeString(this.photo_anggota);
    }

    public About(){

    }

    protected About(Parcel in) {
        this.nama_anggota = in.readString();
        this.nim_anggota = in.readString();
        this.photo_anggota = in.readString();
    }

    public static final Parcelable.Creator<About> CREATOR = new Creator<About>() {
        @Override
        public About createFromParcel(Parcel in) {
            return new About(in);
        }
        @Override
        public About[] newArray(int size) {
            return new About[size];
        }
    };
}
