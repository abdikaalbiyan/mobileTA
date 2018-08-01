package com.konflikgis.konflikgis.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FeaturesTerdekat implements Serializable {
    @SerializedName("nama")
    private String nama;
    @SerializedName("jenisLokasi")
    private String jenisLokasi;
    @SerializedName("jarak")
    private int jarak;
    @SerializedName("error")
    private double jarakAsli;

    public FeaturesTerdekat() {}

    public FeaturesTerdekat(String nama, String jenisLokasi, int jarak, double jarakAsli) {
        this.nama = nama;
        this.jenisLokasi = jenisLokasi;
        this.jarak = jarak;
        this.jarakAsli = jarakAsli;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisLokasi() {
        return jenisLokasi;
    }

    public void setJenisLokasi(String jenisLokasi) {
        this.jenisLokasi = jenisLokasi;
    }

    public int getJarak() {
        return jarak;
    }

    public void setJarak(int jarak) {
        this.jarak = jarak;
    }

    public double getJarakAsli() {
        return jarakAsli;
    }

    public void setJarakAsli(double jarakAsli) {
        this.jarakAsli = jarakAsli;
    }
}
