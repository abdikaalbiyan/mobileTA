package com.konflikgis.konflikgis.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Heatmap implements Serializable {
    @SerializedName("lokasi")
    private String lokasi;

    public Heatmap() {}

    public Heatmap(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
}
