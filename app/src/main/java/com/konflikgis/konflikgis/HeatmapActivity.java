package com.konflikgis.konflikgis;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.konflikgis.konflikgis.Model.KecamatanBody;
import com.konflikgis.konflikgis.Rest.ApiService;
import com.konflikgis.konflikgis.Rest.UtilsApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class HeatmapActivity extends FragmentActivity implements OnMapReadyCallback {
    PolygonOptions polygonOptions;
    private GoogleMap mMap;
    CameraPosition cameraPosition;

    Context mContext;
    ApiService mApiService;

    String tepi[];
    LatLng batas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heatmap);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mContext = this;
        mApiService = UtilsApi.getAPIService();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng surabaya = new LatLng(-7.2756141, 112.6416433);

        mMap.addMarker(new MarkerOptions().position(surabaya).title("Marker in Surabaya"));

        // For zooming automatically to the location of the marker
        cameraPosition = new CameraPosition.Builder().target(surabaya).zoom(9).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        getMarkersPolygon();

    }

    //mengambar polygon
    private void addPolygon(final ArrayList outer) {
        polygonOptions = new PolygonOptions();

        polygonOptions.addAll(outer);
        polygonOptions.strokeColor(Color.rgb(30, 30, 30));
        polygonOptions.strokeWidth(2);
        polygonOptions.fillColor(Color.parseColor("#b50c15"));
        polygonOptions.clickable(true);

        mMap.addPolygon(polygonOptions);

    }

    // Fungsi get JSON Polygon
    private void getMarkersPolygon() {
        mApiService.getKecamatan()
                .enqueue(new Callback<List<KecamatanBody>>() {
                    @Override
                    public void onResponse(Call<List<KecamatanBody>> call, retrofit2.Response<List<KecamatanBody>> response) {

                        Log.d("Doing", "res code :" + response.code() );
                        if (response.isSuccessful()){
                            List<KecamatanBody> list = response.body();

                            for (int i =0; i < list.size(); i++){
                                tepi = list.get(i).getGeom().replace("POLYGON Z ((","").replace("))","").split(",");

                                ArrayList outer = new ArrayList<LatLng>();

                                for (String aTepi : tepi) {
                                    Log.d("poli", aTepi);
                                    String[] latlng = aTepi.split(" ");
                                    batas = new LatLng(Double.parseDouble(latlng[1]), Double.parseDouble(latlng[0]));
                                    outer.add(batas);
                                    Log.d("poli", String.valueOf(batas));
                                }

                                addPolygon(outer);
                            }
                        } else {
                            Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<List<KecamatanBody>> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.getMessage());
                        Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
