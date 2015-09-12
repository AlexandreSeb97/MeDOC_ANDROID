package com.medoc.medoc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.medoc.medoc.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        // Add a marker in Sydney, Australia, and move the camera.
        LatLng pap = new LatLng(18.5790371, -72.28446);
        map.setMyLocationEnabled(true);
        map.addMarker(new MarkerOptions().position(pap).title("Hello Ayiti!"));
        map.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_hospital_2))
                .snippet("Public - Universitaire")
                .position(new LatLng(18.556353, -72.298126))
                .title("Hopital Universitaire de la Paix"));
        map.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_hospital_2))
                .snippet("Privé")
                .position(new LatLng(18.533449, -72.316445))
                .title("Hopital du Canapé-Vert"));
        map.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_hospital_2))
                .snippet("Public - Universitaire")
                .position(new LatLng(18.5393845, -72.3401777))
                .title("Hopital de l'Université d'Etat d'Haiti"));
        map.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_hospital_2))
                .snippet("Public")
                .position(new LatLng(18.538308, -72.3438775))
                .title("Hopital St Francois de Sales"));
        map.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_hospital_2))
                .snippet("Privé")
                .position(new LatLng(18.5373134, -72.3456348))
                .title("Asile Francais"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pap, 13));
    }

    public void onHospitalsClick(View v) {
        Intent i = new Intent(MapsActivity.this, HospitalsActivity.class);
        startActivity(i);
    }
}