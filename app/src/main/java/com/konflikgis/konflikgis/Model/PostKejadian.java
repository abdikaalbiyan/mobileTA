package com.konflikgis.konflikgis.Model;

public class PostKejadian {
    private int id;
    private String daerah;
    private int tahun2013;
    private int tahun2015;
    private int tahun2018;
    private int inputdata;
    private int dataset;

    public PostKejadian(String daerah, int inputData, int dataSet) {
        this.id = 0;
        this.daerah = daerah;
        this.tahun2013 = 0;
        this.tahun2015 = 0;
        this.tahun2018 = 0;
        this.inputdata = inputData;
        this.dataset = dataSet;
    }

    public int getId() {
        return id;
    }

    public String getDaerah() {
        return daerah;
    }

    public int getTahun2013() {
        return tahun2013;
    }

    public int getTahun2015() {
        return tahun2015;
    }

    public int getTahun2018() {
        return tahun2018;
    }

    public int getInputData() {
        return inputdata;
    }

    public int getDataSet() {
        return dataset;
    }
}
