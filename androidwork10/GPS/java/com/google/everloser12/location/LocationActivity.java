package com.google.everloser12.location;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import static android.view.View.OnClickListener;

import java.util.Random;

public class LocationActivity extends FragmentActivity implements
        ConnectionCallbacks, OnConnectionFailedListener, LocationListener {


    public static final float DEFAULT_LAT = 53.906562f;
    public static final float DEFAULT_LON = 27.566582f;
    private static final float OFFSET = 0.1f;
    private static final Random RANDOM = new Random();
    public static String URL =
            "https://maps.googleapis.com/maps/api/staticmap?sensor=false&size=400x400&zoom=13&center=%s,%s";

    private static float lastLatitude;
    private static float lastLongitude;
    private static GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    protected LocationRequest mLocationRequest;
    protected Boolean mRequestingLocationUpdates = false;

    private static float myLat;
    private static float myLon;
    private Button trackButt, clearButt, moveButt;
    private RadioButton rb1, rb2, rb3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_history);

        // Create an instance of GoogleAPIClient.
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }

        clearButt = (Button) findViewById(R.id.clear_location);
        clearButt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tell everyone to clear their location history.
                BusProvider.getInstance().post(new LocationClearEvent());


                if (mRequestingLocationUpdates) {
                    mRequestingLocationUpdates = false;
                    trackButt.setEnabled(true);
                    stopLocationUpdates();
                }
                // Post new location event for the default location.
                if (myLat != 0 && myLon != 0) {
                    lastLatitude = myLat;
                    lastLongitude = myLon;
                } else {
                    lastLatitude = DEFAULT_LAT;
                    lastLongitude = DEFAULT_LON;
                }


                BusProvider.getInstance().post(produceLocationEvent());
            }
        });

        moveButt = (Button) findViewById(R.id.move_location);
        moveButt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mRequestingLocationUpdates) {
                    mRequestingLocationUpdates = false;
                    trackButt.setEnabled(true);
                    stopLocationUpdates();
                }

                lastLatitude += (RANDOM.nextFloat() * OFFSET * 2) - OFFSET;
                lastLongitude += (RANDOM.nextFloat() * OFFSET * 2) - OFFSET;
                BusProvider.getInstance().post(produceLocationEvent());
            }
        });

        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb1.setOnClickListener(radio);
        rb2.setOnClickListener(radio);
        rb3.setOnClickListener(radio);

        trackButt = (Button) findViewById(R.id.button_track);
        trackButt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


                createLocationRequest();
                if (!mRequestingLocationUpdates) {
                    mRequestingLocationUpdates = true;
                    trackButt.setEnabled(false);
                    startLocationUpdates();
                }
            }
        });

    }

    OnClickListener radio = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.radioButton)
                URL = "https://maps.googleapis.com/maps/api/staticmap?sensor=false&size=400x400&zoom=9&center=%s,%s";
            else if (v.getId() == R.id.radioButton2)
                URL = "https://maps.googleapis.com/maps/api/staticmap?sensor=false&size=400x400&zoom=13&center=%s,%s";
            else if (v.getId() == R.id.radioButton3)
                URL = "https://maps.googleapis.com/maps/api/staticmap?sensor=false&size=400x400&zoom=17&center=%s,%s";
            BusProvider.getInstance().post(produceLocationEvent());

        }
    };

    @Override
    protected void onResume() {
        super.onResume();

        // Register ourselves so that we can provide the initial value.
        BusProvider.getInstance().register(this);
        if (mGoogleApiClient.isConnected() && mRequestingLocationUpdates) {
            startLocationUpdates();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Always unregister when an object no longer should be on the bus.
        BusProvider.getInstance().unregister(this);
        if (mGoogleApiClient.isConnected()) {
            stopLocationUpdates();
        }
    }


    @Override
    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    @Override
    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    // @Produce
    public LocationChangedEvent produceLocationEvent() {
        // Provide an initial value for location based on the last known position.
        if (lastLatitude != 0 && lastLongitude != 0)
            return new LocationChangedEvent(lastLatitude, lastLongitude);

        else {
            lastLatitude = DEFAULT_LAT;
            lastLongitude = DEFAULT_LON;
        }
        return new LocationChangedEvent(lastLatitude, lastLongitude);
    }

    @Override
    public void onConnected(Bundle bundle) {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (mLastLocation != null) {

            myLat = (float) mLastLocation.getLatitude();
            myLon = (float) mLastLocation.getLongitude();
            lastLatitude = myLat;
            lastLongitude = myLon;
            BusProvider.getInstance().post(produceLocationEvent());
//
        }

    }

    @Override
    public void onConnectionSuspended(int i) {

        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

        lastLatitude = DEFAULT_LAT;
        lastLongitude = DEFAULT_LON;
        BusProvider.getInstance().post(produceLocationEvent());
    }

    protected void createLocationRequest() {
        mLocationRequest = new LocationRequest();

        // Sets the desired interval for active location updates. This interval is
        // inexact. You may not receive updates at all if no location sources are available, or
        // you may receive them slower than requested. You may also receive updates faster than
        // requested if other applications are requesting location at a faster interval.
        mLocationRequest.setInterval(10000);

        // Sets the fastest rate for active location updates. This interval is exact, and your
        // application will never receive updates faster than this value.
        mLocationRequest.setFastestInterval(5000);

        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    protected void startLocationUpdates() {
        // The final argument to {@code requestLocationUpdates()} is a LocationListener
        // (http://developer.android.com/reference/com/google/android/gms/location/LocationListener.html).
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(
                mGoogleApiClient, mLocationRequest, this);
    }

    protected void stopLocationUpdates() {
        // It is a good practice to remove location requests when the activity is in a paused or
        // stopped state. Doing so helps battery performance and is especially
        // recommended in applications that request frequent location updates.

        // The final argument to {@code requestLocationUpdates()} is a LocationListener
        // (http://developer.android.com/reference/com/google/android/gms/location/LocationListener.html).
        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;
        lastLatitude = (float) mLastLocation.getLatitude();
        lastLongitude = (float) mLastLocation.getLongitude();
        BusProvider.getInstance().post(produceLocationEvent());


    }
}