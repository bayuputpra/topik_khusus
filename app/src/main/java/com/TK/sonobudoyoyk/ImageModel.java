package com.TK.sonobudoyoyk;

public class ImageModel {
    public ImageModel() {
    }

    public ImageModel(String nama, String deskripsi, String image) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.image = image;
        this.id = id;
        this.ruang = ruang;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRuang() {
        return ruang;
    }

    public void setRuang(String ruang) {
        this.ruang = ruang;
    }

    String nama;
    String deskripsi;
    String image;
    String id;
    String ruang;
}
