/**
* Created by: Muhammad Amiral
* Mar 13, 2011
*/

package com.tangerangmaps.util;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MapRoute extends Activity{
	
	private LocationManager locman;
	private LocationListener loclis;
	private List<String> l_providers;
	private String s_provider;
	@Override
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		String s_method = getIntent().getStringExtra("method");
		
		/* Use the LocationManager class to obtain GPS locations */
		
    	locman = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		loclis = new LocationListener(){
			public void onLocationChanged(Location loc)

			{
				String Text = "Current location is: " +
				"Latitud = " + loc.getLatitude() +
				" Longitud = " + loc.getLongitude() +
				" Accuracy = " + loc.getAccuracy();

				Toast.makeText( getApplicationContext(),Text,Toast.LENGTH_SHORT).show();
			}
			
			public void onStatusChanged(String s_provider, int status, Bundle extras)

			{

			}
			
			public void onProviderDisabled(String s_provider)

			{

			}

			public void onProviderEnabled(String s_provider)

			{

			}

		};/* End of Class MyLocationListener */
		 
    	if (("GPS").equals(s_method)){
    		locman.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, loclis);
    	}
    	else{
    		locman.requestLocationUpdates( LocationManager.NETWORK_PROVIDER, 0, 0, loclis);
    	}
		
		l_providers = locman.getProviders(true);
		Location last_known_location = null;
		
		for (int x=l_providers.size()-1; x>=0; x--) {
			last_known_location = locman.getLastKnownLocation(l_providers.get(x));
			s_provider = l_providers.get(x);
			if (last_known_location != null) break;
		}
		
    	/*
		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		provider = locman.getBestProvider(criteria, true);

		Location last_known_location = locman.getLastKnownLocation(provider);
		*/
		
		//Destination coordinates
    	
    	String s_lat = getIntent().getStringExtra("latitude");
    	String s_lon = getIntent().getStringExtra("longitude");		

    	Log.i("tm", "Latitude: " +s_lat);
    	Log.i("tm", "Longitud: " +s_lon);
    	Log.i("tm", "last_known_location.getLatitude(): " +last_known_location.getLatitude());
    	Log.i("tm", "last_known_location.getLongitude(): " +last_known_location.getLongitude());
		
  	  /*
				# * The Possible Query params options are the following:  
				# *  
				# * Show map at location: geo:latitude,longitude  
				# * Show zoomed map at location: geo:latitude,longitude?z=zoom  
				# * Show map at locaiton with point: geo:0,0?q=my+street+address  
				# * Show map of businesses in area: geo:0,0?q=business+near+city  
 	   */
		
  	  	String uri = "http://maps.google.com/maps?saddr="
  	  		+last_known_location.getLatitude()+","+last_known_location.getLongitude()
  	  		+"&daddr="+s_lat+","+s_lon+"&z=17";
        startActivity(new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri)));			
	}	

	/** Register for the updates when Activity is in foreground */
	@Override
	protected void onResume() {
		super.onResume();
		locman.requestLocationUpdates(s_provider, 20000, 1, loclis);
	}

	/** Stop the updates when Activity is paused */
	@Override
	protected void onPause() {
		super.onPause();
		locman.removeUpdates(loclis);
	}    

	/** Stop the updates when Activity is paused */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		locman.removeUpdates(loclis);
	}    	

}
