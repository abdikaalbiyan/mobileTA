package com.konflikgis.konflikgis.Rest;

import com.konflikgis.konflikgis.Model.KecamatanBody;
import com.konflikgis.konflikgis.Model.KejadianBody;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    // Fungsi ini untuk memanggil API http://192.168.43.230/api/kecamatan
    @GET("kecamatanAll")
    Call<List<KecamatanBody>> getKecamatan();

    @GET("zKejadian")
    Call<List<KejadianBody>> getKejadian();
}
