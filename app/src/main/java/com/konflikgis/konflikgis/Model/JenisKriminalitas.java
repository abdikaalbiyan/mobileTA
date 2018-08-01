package com.konflikgis.konflikgis.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class JenisKriminalitas implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("jenis")
    private String jenis;

    public JenisKriminalitas() {}

    public JenisKriminalitas(int id, String jenis) {
        this.id = id;
        this.jenis = jenis;
    }

    public int getId() {
        return id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
}
