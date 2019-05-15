package com.example.artexplore;

import android.os.Parcel;
import android.os.Parcelable;

public class Daerah implements Parcelable {
    private String nama_daerah;
    private String photo_daerah;

    public String getNama_daerah() {
        return nama_daerah;
    }

    public void setNama_daerah(String nama_daerah) {
        this.nama_daerah = nama_daerah;
    }

    public String getPhoto_daerah() {
        return photo_daerah;
    }

    public void setPhoto_daerah(String photo_daerah) {
        this.photo_daerah = photo_daerah;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama_daerah);
        dest.writeString(this.photo_daerah);
    }

    public Daerah(){

    }

    protected Daerah(Parcel in) {
        this.nama_daerah = in.readString();
        this.photo_daerah = in.readString();
    }

    public static final Parcelable.Creator<Daerah> CREATOR = new Creator<Daerah>() {
        @Override
        public Daerah createFromParcel(Parcel in) {
            return new Daerah(in);
        }
        @Override
        public Daerah[] newArray(int size) {
            return new Daerah[size];
        }
    };
}
