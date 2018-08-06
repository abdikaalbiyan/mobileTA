package com.konflikgis.konflikgis.Rest;

import com.konflikgis.konflikgis.Model.KecamatanBody;
import com.konflikgis.konflikgis.Model.KecamatanBody2;
import com.konflikgis.konflikgis.Model.KejadianBody;
import com.konflikgis.konflikgis.Model.PostKejadian;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {

    // Fungsi ini untuk memanggil API http://192.168.43.230/api/kecamatan
    @GET("kecamatanAll")
    Call<List<KecamatanBody>> getKecamatan();

    @GET("zKejadian")
    Call<List<KejadianBody>> getKejadian();

    @GET("historikonflik/All")
    Call<List<KecamatanBody2>> getSpinKecamatan();


    @POST("historikonflik")
    Call<PostKejadian> postKejadian(
            @Header("Accept") String accept,
            @Header("Content-Type") String content,
            @Body PostKejadian postKejadian
    );
}
