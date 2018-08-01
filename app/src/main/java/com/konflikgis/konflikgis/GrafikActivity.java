package com.konflikgis.konflikgis;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.konflikgis.konflikgis.Model.KejadianBody;
import com.konflikgis.konflikgis.Rest.ApiService;
import com.konflikgis.konflikgis.Rest.UtilsApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GrafikActivity extends AppCompatActivity {
    ScatterChart scatterChart;

    Context mContext;
    ApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafik);

        mContext = this;
        mApiService = UtilsApi.getAPIService();

        BarChart chart = (BarChart) findViewById(R.id.chart);
        BarData data = new BarData(getXAxisValues(), getDataSet());

        chart.setData(data);
        chart.setDescription("My Chart");
        chart.animateXY(2000, 2000);
        chart.invalidate();

         scatterChart = (ScatterChart) findViewById(R.id.scater);

        //scaterChart();
        getScatterPlot();
    }

    public void getScatterPlot() {
        mApiService.getKejadian()
                .enqueue(new Callback<List<KejadianBody>>() {
                    @Override
                    public void onResponse(Call<List<KejadianBody>> call, Response<List<KejadianBody>> response) {
                        Log.d("Doing", "res code :" + response.code() );
                        if (response.isSuccessful()){
                            List<KejadianBody> list = response.body();

                            ArrayList <Entry> entries = new ArrayList();
                            ArrayList<String> labels = new ArrayList<String>();

                            for (int i =0; i < list.size(); i++){
                                String zetKejadian = list.get(i).getZetKejadian();
                                String bobotZKejadian = list.get(i).getBobotZKejadian();

                                Log.d("zKejadian", zetKejadian);

                                entries.add(new Entry(Float.parseFloat(zetKejadian), i));

                                labels.add(bobotZKejadian);
                            }

                            ScatterDataSet dataset = new ScatterDataSet(entries, "# of Calls");

                            ScatterData dataLabel = new ScatterData(labels, dataset);
                            scatterChart.setData(dataLabel); // set the data and list of lables into chart
                            scatterChart.setDescription("Scatter Data");

                            dataset.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
                            dataset.setScatterShapeSize(10);
                            dataset.setColors(ColorTemplate.COLORFUL_COLORS);
                            scatterChart.animateY(5000);

                        } else {
                            Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<List<KejadianBody>> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.getMessage());
                        Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();

                    }
                });
    }

    private ArrayList<IBarDataSet> getDataSet() {

        ArrayList<IBarDataSet> dataSets = null;
        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e1 = new BarEntry(4, 0); // Benowo
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry(2, 1); // Pakal
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(5, 2); // Sambikerep
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(3, 3); // Lakasantri
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(5, 4); // Asemrowo
        valueSet1.add(v1e5);
        BarEntry v1e6 = new BarEntry(6, 5); // Tandes
        valueSet1.add(v1e6);
        BarEntry v1e7 = new BarEntry(5, 6); // Krembangan
        valueSet1.add(v1e7);
        BarEntry v1e8 = new BarEntry(8, 7); // Sukomanunggal
        valueSet1.add(v1e8);
        BarEntry v1e9 = new BarEntry(8, 8); // Dukuhpakis
        valueSet1.add(v1e9);
        BarEntry v1e10 = new BarEntry(5, 9); // Wiyung
        valueSet1.add(v1e10);
        BarEntry v1e11 = new BarEntry(5, 10); // Pabean Cantikan
        valueSet1.add(v1e11);
        BarEntry v1e12 = new BarEntry(5, 11); // Semampir
        valueSet1.add(v1e12);
        BarEntry v1e13 = new BarEntry(5, 12); // Kenjeran
        valueSet1.add(v1e13);
        BarEntry v1e14 = new BarEntry(8, 13); // Bubutan
        valueSet1.add(v1e14);
        BarEntry v1e15 = new BarEntry(5, 14); // Sawahan
        valueSet1.add(v1e15);
        BarEntry v1e16 = new BarEntry(5, 15); // Simokerto
        valueSet1.add(v1e16);
        BarEntry v1e17 = new BarEntry(8, 16); // Genteng
        valueSet1.add(v1e17);
        BarEntry v1e18 = new BarEntry(5, 17); // Tambaksari
        valueSet1.add(v1e18);
        BarEntry v1e19 = new BarEntry(3, 18); // Bulak
        valueSet1.add(v1e19);
        BarEntry v1e20 = new BarEntry(8, 19); // Tegalsari
        valueSet1.add(v1e20);
        BarEntry v1e21 = new BarEntry(8, 20); // Wonokromo
        valueSet1.add(v1e21);
        BarEntry v1e22 = new BarEntry(8, 21); // Gubeng
        valueSet1.add(v1e22);
        BarEntry v1e23 = new BarEntry(5, 22); // Karangpilang
        valueSet1.add(v1e23);
        BarEntry v1e24 = new BarEntry(5, 23); // Jambangan
        valueSet1.add(v1e24);
        BarEntry v1e25 = new BarEntry(5, 24); // Gayungan
        valueSet1.add(v1e25);
        BarEntry v1e26 = new BarEntry(5, 25); // Wonocolo
        valueSet1.add(v1e26);
        BarEntry v1e27 = new BarEntry(5, 26); // Tenggilis Mejoyo
        valueSet1.add(v1e27);
        BarEntry v1e28 = new BarEntry(8, 27); // Mulyorejo
        valueSet1.add(v1e28);
        BarEntry v1e29 = new BarEntry(5, 28); // Sukolilo
        valueSet1.add(v1e29);
        BarEntry v1e30 = new BarEntry(3, 29); // Rungkut
        valueSet1.add(v1e30);
        BarEntry v1e31 = new BarEntry(3, 30); // Gununganyar
        valueSet1.add(v1e31);

//        ArrayList<BarEntry> valueSet2 = new ArrayList<>();
//        BarEntry v2e1 = new BarEntry(4f, 0); // Jan
//        valueSet2.add(v2e1);
//        BarEntry v2e2 = new BarEntry(2f, 1); // Feb
//        valueSet2.add(v2e2);
//        BarEntry v2e3 = new BarEntry(5f, 2); // Mar
//        valueSet2.add(v2e3);
//        BarEntry v2e4 = new BarEntry(3f, 3); // Apr
//        valueSet2.add(v2e4);
//        BarEntry v2e5 = new BarEntry(5f, 4); // May
//        valueSet2.add(v2e5);
//        BarEntry v2e6 = new BarEntry(6f, 5); // Jun
//        valueSet2.add(v2e6);

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Kecamatan");
        barDataSet1.setColor(Color.rgb(0, 155, 0));
//        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Mie Ayam");
        //barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);
//        barDataSet2.setColor(Color.rgb(193, 37, 82));

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
//        dataSets.add(barDataSet2);

        return dataSets;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("Benowo");
        xAxis.add("Pakal");
        xAxis.add("Sambikerep");
        xAxis.add("Lakasantri");
        xAxis.add("Asemrowo");
        xAxis.add("Tandes");
        xAxis.add("Krembangan");
        xAxis.add("Sukomanunggal");
        xAxis.add("Dukuhpakis");
        xAxis.add("Wiyung");
        xAxis.add("Pabean Cantikan");
        xAxis.add("Semampir");
        xAxis.add("Kenjeran");
        xAxis.add("Bubutan");
        xAxis.add("Sawahan");
        xAxis.add("Simokerto");
        xAxis.add("Genteng");
        xAxis.add("Tambaksari");
        xAxis.add("Bulak");
        xAxis.add("Tegalsari");
        xAxis.add("Wonokromo");
        xAxis.add("Gubeng");
        xAxis.add("Karangpilang");
        xAxis.add("Jambangan");
        xAxis.add("Gayungan");
        xAxis.add("Wonocolo");
        xAxis.add("Tenggilis Mejoyo");
        xAxis.add("Mulyorejo");
        xAxis.add("Sukolilo");
        xAxis.add("Rungkut");
        xAxis.add("Gununganyar");
        return xAxis;

    }

    public void scaterChart() {

        ArrayList <Entry> entries = new ArrayList();
        entries.add(new Entry(4f, 0));
        entries.add(new Entry(8f, 1));
        entries.add(new Entry(6f, 2));
        entries.add(new Entry(12f, 3));
        entries.add(new Entry(18f, 4));
        entries.add(new Entry(9f, 5));
        ScatterDataSet dataset = new ScatterDataSet(entries, "# of Calls");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Jan");
        labels.add("Feb");
        labels.add("Mar");
        labels.add("Apr");
        labels.add("May");
        labels.add("Jun");
        ScatterData dataLabel = new ScatterData(labels, dataset);
        scatterChart.setData(dataLabel); // set the data and list of lables into chart
        scatterChart.setDescription("Scatter Data");

        dataset.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
        dataset.setScatterShapeSize(10);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        scatterChart.animateY(5000);
    }

}
