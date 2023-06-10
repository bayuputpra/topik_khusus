package com.TK.sonobudoyoyk.model;

import android.os.Parcel;
import android.os.Parcelable;

public class news implements Parcelable {
    private String title, description, foto;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public news(){

    }

    protected news(Parcel in) {
        title = in.readString();
        description = in.readString();
        foto = in.readString();
    }

    public static final Creator<news> CREATOR = new Creator<news>() {
        @Override
        public news createFromParcel(Parcel in) {
            return new news(in);
        }

        @Override
        public news[] newArray(int size) {
            return new news[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(foto);
    }
}
