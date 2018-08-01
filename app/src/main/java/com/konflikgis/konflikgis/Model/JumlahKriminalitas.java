package com.konflikgis.konflikgis.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class JumlahKriminalitas implements Serializable {
    @SerializedName("idJenisKriminalitas")
    private int idJenisKriminalitas;
    @SerializedName("bulan")
    private int bulan;
    @SerializedName("jumlah")
    private int jumlah;
    @SerializedName("error")
    private double error;

    public JumlahKriminalitas() {}

    public JumlahKriminalitas(int idJenisKriminalitas, int bulan, int jumlah, double error) {
        this.idJenisKriminalitas = idJenisKriminalitas;
        this.bulan = bulan;
        this.jumlah = jumlah;
        this.error = error;
    }

    public int getIdJenisKriminalitas() {
        return idJenisKriminalitas;
    }

    public void setIdJenisKriminalitas(int idJenisKriminalitas) {
        this.idJenisKriminalitas = idJenisKriminalitas;
    }

    public int getBulan() {
        return bulan;
    }

    public void setBulan(int bulan) {
        this.bulan = bulan;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getError() {
        return error;
    }

    public void setError(double error) {
        this.error = error;
    }
}
