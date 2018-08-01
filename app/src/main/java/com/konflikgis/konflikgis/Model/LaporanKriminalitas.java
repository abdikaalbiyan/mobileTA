package com.konflikgis.konflikgis.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LaporanKriminalitas implements Serializable {
    @SerializedName("id")
    private int id;
    private int idJenisKriminalitas;
    private int idPelapor;
    private String lokasi;
    private String waktuKejadian;

    public LaporanKriminalitas() {}

    public LaporanKriminalitas(int id, int idJenisKriminalitas, int idPelapor, String lokasi, String waktuKejadian) {
        this.id = id;
        this.idJenisKriminalitas = idJenisKriminalitas;
        this.idPelapor = idPelapor;
        this.lokasi = lokasi;
        this.waktuKejadian = waktuKejadian;
    }

    public int getId() {
        return id;
    }

    public int getIdJenisKriminalitas() {
        return idJenisKriminalitas;
    }

    public int getIdPelapor() {
        return idPelapor;
    }

    public String getLokasi() {
        return lokasi;
    }

    public String getWaktuKejadian() {
        return waktuKejadian;
    }
}
