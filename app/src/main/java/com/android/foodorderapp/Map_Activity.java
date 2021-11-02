package com.android.foodorderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.fragment.app.FragmentActivity;
import androidx.annotation.NonNull;

public class Map_Activity extends FragmentActivity implements OnMapReadyCallback
{
    Button toHome;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.MapArea);

        mapFragment.getMapAsync(this);

        toHome = findViewById(R.id.toHome);
        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Home = new Intent(Map_Activity.this,MainActivity.class);
                startActivity(Home);
            }
        });

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap)
    {
   // this.mMap = googleMap;
/*
    this.mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    this.mMap.getUiSettings().setRotateGesturesEnabled(true);
    this.mMap.getUiSettings().setZoomGesturesEnabled(true);
    this.mMap.setTrafficEnabled(true);*/

    LatLng appLatLong = new LatLng(18.526412503178705, 73.82995723426325);
    googleMap.addMarker(new MarkerOptions()
            .position(appLatLong)
            .title("Starting"));
    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(appLatLong,20));

    }

}
