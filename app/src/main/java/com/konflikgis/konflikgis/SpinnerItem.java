package com.konflikgis.konflikgis;

/**
 * Created by asmarasusanto on 11/10/17.
 */

public class SpinnerItem {

    private int id;
    private String title;
    private int dataSet;

    public SpinnerItem(int id, String title, int dataSet) {
        this.id = id;
        this.title = title;
        this.dataSet = dataSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDataSet() {
        return dataSet;
    }

    public void setDataSet(int dataSet) {
        this.dataSet = dataSet;
    }
}
