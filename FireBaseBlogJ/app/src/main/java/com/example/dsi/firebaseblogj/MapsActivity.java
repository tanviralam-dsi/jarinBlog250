package com.example.dsi.firebaseblogj;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.PermissionChecker;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng[] places;
    private String[] titles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        initArray();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void initArray() {
        places = new LatLng[25];
        titles = new String[75];
        places[0] = new LatLng(23.8099,90.4312); //Apollo Hospital, Dhaka
        titles[0] = new String("Apollo Hospital");

        places[1] = new LatLng(23.881510,90.404334); //Aichi Hospital, Dhaka
        titles[1] = new String("Aichi Hospital");

        places[2] = new LatLng(23.751562,90.369094); //IBN Sina Hospital,Dhaka
        titles[2] = new String("IBN Sina Hospital");

        places[3] = new LatLng(23.750285,90.369896); //Bangladesh Medical College Hospital,Dhaka
        titles[3] = new String("Bangladesh Medical College Hospitals");

        places[4] = new LatLng(23.8045708,90.4155583); //United Hospital,Dhaka
        titles[4] = new String("United Hospital");

        places[5] = new LatLng(23.752986,90.381469); //Square Hospital,Dhaka
        titles[5] = new String("Square Hospital");

        places[6] = new LatLng(23.711085,90.401044); //Sir Salimullah Medical College Mitford Hospital,Dhaka
        titles[6] = new String("Sir Salimullah Medical College");

        places[7] = new LatLng(23.752545,90.385110); //Samorita Hospital,Dhaka
        titles[7] = new String("Samorita Hospital");

        places[8] = new LatLng(23.739112, 90.382262); // Popular  Medical College  Hospital,Dhaka
        titles[8] = new String("Popular  Medical College  Hospital");

        places[9] = new LatLng(23.776133, 90.395724); // Aysha Memorial Specialised Hospital, Dhaka
        titles[9] = new String("Aysha Memorial Specialised Hospital");

        places[10] = new LatLng(23.814111, 90.397806); // Combined Military Hospital,Dhaka
        titles[10] = new String("Combined Military Hospital");

        places[11] = new LatLng(23.741843, 90.383074); // Labaid Specialized Hospital, Dhaka
        titles[11] = new String("Labaid Specialized Hospital");

        places[12] = new LatLng(23.725224, 90.397486); // Dhaka Medical College & Hospital,Dhaka
        titles[12] = new String("Dhaka Medical College");

        places[13] = new LatLng(23.773085, 90.368818); //Dhaka Shishu Hospital,Dhaka
        titles[13] = new String("Dhaka Shishu Hospital");

        places[14] = new LatLng(24.900117, 91.853110); //Institute of Child and Mother Health, Dhaka
        titles[14] = new String("Osmani Medical");

        places[15] = new LatLng(24.913187, 91.852825); //Ad-din Women's Medical College Hospital,Dhaka
        titles[15] = new String("Ragib-Rabeya Medical");

        places[16] = new LatLng(24.898569, 91.872450); //Anwer Khan Modern Hospital,Dhaka
        titles[16] = new String("Sylhet Women's Medical");

        places[17] = new LatLng(23.738890, 90.396455); //BIRDEM,Dhaka
        titles[17] = new String("BIRDEM");

        places[18] = new LatLng(24.887663, 91.880993); //Central Hospital,Dhaka
        titles[18] = new String("Sylhet Shishu Clinic");

        places[19] = new LatLng(24.886745, 91.882236); //Bangabandhu Sheikh Mujib Medical,Dhaka
        titles[19] = new String("Sylhet Eye Hospital");

        places[20] = new LatLng(24.909085, 91.838411); //Esperto Healthcare,Dhaka
        titles[20] = new String("Friends Eye Hospital");

        places[21] = new LatLng(23.746756, 90.403384); //Holy Family Red Crescent Medical College and Hospital,Dhaka
        titles[21] = new String("National Heart Foundation");

        places[22] = new LatLng(24.945831, 91.870837); //Uttara Adhunik Medical College and Hospital,Dhaka
        titles[22] = new String("Cadet College Hospital");

        places[23] = new LatLng(24.895331, 91.884948); //Medinova Medical ,Dhaka
        titles[23] = new String("Sporsho Medical");

        places[24] = new LatLng(24.899883, 91.855124); //Rashmono Hospital,Dhaka
        titles[24] = new String("Medinova");

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
        for (int i = 0; i < places.length; i++) {
            mMap.addMarker(new MarkerOptions().position(places[i]).title(titles[i]));

        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(places[15],12f));
        if (PermissionChecker.checkSelfPermission(MapsActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);



        //mMap.setMyLocationEnabled(true);
    }
}
