package com.tangerangmaps.ui;

import greendroid.app.GDMapActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.tangerangmaps.R;

public class NearByMap extends GDMapActivity{

	MapView mapView;
	Context mContext;	
	String userLat, userLon;
	SharedPreferences userLocation;
	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		setActionBarContentView(R.layout.map_near_by);
		mContext = this;
		
		userLat = userLocation.getString("userLat", "0");
		mapView = (MapView) findViewById(R.id.mapNearby);
		mapView.setBuiltInZoomControls(true);
	}
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
