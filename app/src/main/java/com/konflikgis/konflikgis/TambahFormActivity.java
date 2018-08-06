package com.konflikgis.konflikgis;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.konflikgis.konflikgis.Model.KecamatanBody2;
import com.konflikgis.konflikgis.Model.PostKejadian;
import com.konflikgis.konflikgis.Rest.ApiService;
import com.konflikgis.konflikgis.Rest.UtilsApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahFormActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private Spinner spinner;
    private SpinAdapter spinAdapter;
    private ArrayList<SpinnerItem> spinnerItems = new ArrayList<>();

    private EditText edtKejadian;
    private Button btnSubmit;

    private int dataSet = 0;
    private String kecamatan = "";
    private ApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_form);

        mApiService = UtilsApi.getAPIService();

        toolbar = findViewById(R.id.tambah_form_activity_toolbar);
        edtKejadian = findViewById(R.id.edtKejadian);
        btnSubmit = findViewById(R.id.btn_kirim);

        spinner = findViewById(R.id.jenis_kriminalitas_sp);
        spinAdapter = new SpinAdapter(getApplicationContext(), spinnerItems);
        spinner.setAdapter(spinAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                kecamatan = spinnerItems.get(i).getTitle();
                dataSet = spinnerItems.get(i).getDataSet();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jmlKejadian = edtKejadian.getText().toString().trim();
                if (jmlKejadian.isEmpty() && kecamatan.isEmpty() && dataSet == 0){
                    Toast.makeText(TambahFormActivity.this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else {
                    upload(jmlKejadian);
                }
            }
        });

        setToolbar();
        getKecamatan();
    }

    private void getKecamatan() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        mApiService.getSpinKecamatan()
                .enqueue(new Callback<List<KecamatanBody2>>() {
                    @Override
                    public void onResponse(Call<List<KecamatanBody2>> call, Response<List<KecamatanBody2>> response) {
                        if (response.isSuccessful()){
                            if (response.body().size() != 0){
                                for (KecamatanBody2 kecamatanBody2 : response.body()){
                                    spinnerItems.add(new SpinnerItem(kecamatanBody2.getId(), kecamatanBody2.getDaerah(), kecamatanBody2.getDataSet()));
                                }
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.hide();
                        spinAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<List<KecamatanBody2>> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.getMessage());
                        Toast.makeText(getApplicationContext(), "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();

                    }
                });
    }

    private void upload(String jmlKejadian) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        PostKejadian kejadian = new PostKejadian(kecamatan, Integer.parseInt(jmlKejadian), dataSet);

        mApiService.postKejadian("application/json","application/json", kejadian)
                .enqueue(new Callback<PostKejadian>() {
                    @Override
                    public void onResponse(Call<PostKejadian> call, Response<PostKejadian> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(TambahFormActivity.this, "Input data berhasil", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.hide();
                    }

                    @Override
                    public void onFailure(Call<PostKejadian> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.getMessage());
                        Toast.makeText(getApplicationContext(), "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();

                    }
                });
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tambah Data Kejadian");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
