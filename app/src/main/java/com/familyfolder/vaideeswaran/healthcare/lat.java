package com.familyfolder.vaideeswaran.healthcare;
import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class lat extends AppCompatActivity {
    private TextView latituteField;
    private TextView longitudeField;
    private LocationManager locationManager;
    private String provider;
    GPSTracker gps;
    float longi=10, lati=20;


    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lat);
        gps = new GPSTracker(lat.this);
        Location location = null;
        latituteField = (TextView) findViewById(R.id.textView10);
        longitudeField = (TextView) findViewById(R.id.textView11);


        // Get the location manager
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // Define the criteria how to select the locatioin provider -> use
//        // default
      longi = (float) gps.getLongitude();
        lati = (float) gps.getLatitude();

      String long2 = ""+longi;
        String lat2 = ""+lati;
        latituteField.setText(long2);
        longitudeField.setText(lat2);
    }
}
  /*
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        try {
          location  = locationManager.getLastKnownLocation(provider);
        }
        catch (SecurityException e)
        {
            Log.d("v","one");

        }

        // Initialize the location fields
        if (location != null) {
            System.out.println("Provider " + provider + " has been selected.");
            onLocationChanged(location);
        } else {
            latituteField.setText("Location not available");
            longitudeField.setText("Location not available");
        }
    }

    /* Request updates at startup */
/*    @Override
    protected void onResume() {
        super.onResume();
        try {
            locationManager.requestLocationUpdates(provider, 400, 1, this);
        }   catch (SecurityException e)
        {
            Log.d("v","two");
        }

    }

    /* Remove the locationlistener updates when Activity is paused
    @Override
    protected void onPause() {
        super.onPause();
        try {
            locationManager.removeUpdates(this);
        }   catch (SecurityException e)
        {
            Log.d("v","three");
        }

    }

    @Override
    public void onLocationChanged(Location location) {
        int lat = (int) (location.getLatitude());
        int lng = (int) (location.getLongitude());
        latituteField.setText(String.valueOf(lat));
        longitudeField.setText(String.valueOf(lng));
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        //TODO Auto-generated method stub

    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(this, "Enabled new provider " + provider,
                Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(this, "Disabled provider " + provider,
                Toast.LENGTH_SHORT).show();
    }
}
*/