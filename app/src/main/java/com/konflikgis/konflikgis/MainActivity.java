package com.konflikgis.konflikgis;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.konflikgis.konflikgis.Rest.ApiService;

public class MainActivity extends AppCompatActivity {
    private LinearLayout heatmapLL;
    private LinearLayout hotspotLL;
    private LinearLayout laporkanKejadianLL;
    private LinearLayout tentangLL;
    public static Activity mainActivity;
    private Toolbar toolbar;
    private ApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heatmapLL = (LinearLayout) this.findViewById(R.id.heatmap_ll);
        hotspotLL = (LinearLayout) this.findViewById(R.id.hotspot_ll);
        laporkanKejadianLL = (LinearLayout) this.findViewById(R.id.laporkan_kejadian_ll);
        tentangLL = (LinearLayout) this.findViewById(R.id.tentang_ll);
        toolbar = (Toolbar) findViewById(R.id.main_activity_toolbar);

        setSupportActionBar(toolbar);

        heatmapLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HeatmapActivity.class);
                startActivity(intent);
            }
        });

        hotspotLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GrafikActivity.class);
                startActivity(intent);
            }
        });

        laporkanKejadianLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TambahFormActivity.class);

                startActivity(intent);
            }
        });

        tentangLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);

                startActivity(intent);
            }
        });
    }
}