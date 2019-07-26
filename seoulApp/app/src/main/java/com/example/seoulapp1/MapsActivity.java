package com.example.seoulapp1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private Button button;
    private Button update;
    private static final int REQUEST_CODE_PERMISSIOINS = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        button = (Button)findViewById(R.id.find_btn);
        update = (Button) findViewById(R.id.update_btn) ;
        Intent intent = new Intent(this.getIntent());
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);


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
        final HashMap<String, Double> latitude = new HashMap<String, Double>();
        final HashMap<String, Double> longitude = new HashMap<String, Double>();

        Toast.makeText(getApplicationContext(), "안심벨과 서울교통공사가 최근 도입한 비명감지시스템이 설치되어있는 서울 지하철화장실을 알려줄게요~", Toast.LENGTH_LONG).show();

        try{
            NetworkTask getlocation = new NetworkTask("api/location", "get", null, null);
            getlocation.execute();
            String s =  getlocation.get();
            Log.d("getcalendar:", s);
            JSONArray locationList = new JSONArray(s);

            for(int i=0; i<locationList.length(); i++) {
                JSONObject json = (JSONObject) locationList.get(i);
                String place = json.getString("place");
                latitude.put(place,json.getDouble("latitude"));
                longitude.put(place,json.getDouble("longitude"));
                LatLng LOCATION = new LatLng(latitude.get(place), longitude.get(place));
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(LOCATION);
                markerOptions.title(place + "역");
                markerOptions.snippet(place + "역");
                mMap.addMarker(markerOptions);
            }

        }
        catch(Exception e){

        }

        LatLng SEOUL = new LatLng(37.56, 126.97);
        final MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.snippet("지하철 안심화장실을 알려줄게요");
        markerOptions.position(SEOUL);
        markerOptions.title("서울");
        EditText userInput = (EditText) findViewById(R.id.editText);

        userInput.setText(null);
        userInput.setHint("Enter");
        mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SEOUL, 15));
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userInput = (EditText) findViewById(R.id.editText);
                String input = userInput.getText().toString();
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(userInput.getWindowToken(), 0);
                if (latitude.containsKey(input)) {
                    LatLng LOCATION = new LatLng(latitude.get(input), longitude.get(input));
                    markerOptions.position(LOCATION);
                    markerOptions.title(input);
                    mMap.addMarker(markerOptions);
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(LOCATION));

                    Log.e("JSON Parser", "Error parsing data " + latitude.get(input).toString());

                } else {
                    Toast.makeText(getApplicationContext(), "아직 준비되지 않았습니다", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }
    public void onLastLocationButtonClicked(View view) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    REQUEST_CODE_PERMISSIOINS);
            return;
        }
        mFusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null) {
                    LatLng myLocation = new LatLng(location.getLatitude(), location.getLongitude());
                    mMap.addMarker(new MarkerOptions()
                            .position(myLocation)
                            .title("현재 내 위치")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(14.0f));
                }
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode) {
            case REQUEST_CODE_PERMISSIOINS:
                if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager
                        .PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "현재 내 위치를 업데이트할 수 없습니다. 권한 허가가 필요합니다.", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(this, "버튼을 누르면 현재 내 위치를 업데이트 할 수 있습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
