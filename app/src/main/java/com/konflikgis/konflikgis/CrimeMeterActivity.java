package com.konflikgis.konflikgis;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.konflikgis.konflikgis.Model.FeaturesTerdekat;
import com.konflikgis.konflikgis.Model.JenisKriminalitas;
import com.konflikgis.konflikgis.Model.JenisLokasi;
import com.konflikgis.konflikgis.Model.JumlahKriminalitas;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CrimeMeterActivity extends AppCompatActivity {
    private Activity crimeMeterActivity;
    private ArrayList<JenisKriminalitas> jenisKriminalitasArrayList;
    private ArrayList<JenisLokasi> jenisLokasiArrayList;
    private ArrayList<List<JumlahKriminalitas>> jumlahKriminalitasArrayList;
    private ArrayList<FeaturesTerdekat> featuresTerdekatArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_meter);

        // Inisialisasi variabel
        Intent intent = getIntent();
        jenisKriminalitasArrayList = (ArrayList<JenisKriminalitas>) intent.getSerializableExtra("jenisKriminalitas");
        jenisLokasiArrayList = (ArrayList<JenisLokasi>) intent.getSerializableExtra("jenisLokasi");
        jumlahKriminalitasArrayList = (ArrayList<List<JumlahKriminalitas>>) intent.getSerializableExtra("jumlahKriminalitas");
        featuresTerdekatArrayList = (ArrayList<FeaturesTerdekat>) intent.getSerializableExtra("featuresTerdekat");
        crimeMeterActivity = this;

        Log.i("Hasil Extra", "jenis kriminalitas " + jenisKriminalitasArrayList.size());
    }
}
