package com.example.karrismatic;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationListener;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap gMap;
    List list = new ArrayList();
    int j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.google_map);
        supportMapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        //list = list;
        j = 0;
        gMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                //creat marker
                MarkerOptions markerOptions = new MarkerOptions();
                //set marker pos
                markerOptions.position(latLng);
                //set lat et long on map
                markerOptions.title(String.valueOf(j));
                j = j+1;
                list.add(markerOptions.position(latLng));
                //ad marker on map
                gMap.addMarker(markerOptions);
            }
        });

    }
}
