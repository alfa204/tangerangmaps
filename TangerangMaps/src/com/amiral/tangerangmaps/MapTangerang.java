package com.amiral.tangerangmaps;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class MapTangerang extends MapActivity {
	private MapView mapView;
	private MapController mapController;
	private GeoPoint p;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        
        mapView = (MapView) findViewById(R.id.maptangerang);
        
        mapController = mapView.getController();
		
		//Configure the map display options
		mapView.setStreetView(true);
		
		LinearLayout zoomLayout=(LinearLayout) findViewById(R.id.zoom);
		View zoomView=mapView.getZoomControls();
		
		zoomLayout.addView(zoomView,
				new LinearLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
		
		mapView.displayZoomControls(true);
		
		mapController= mapView.getController();
		String coordinate[]={"-6.170252","106.653471"};
		double lat=Double.parseDouble(coordinate[0]);
		double lon=Double.parseDouble(coordinate[1]);
		
		p=new GeoPoint((int) (lat*1E6), (int)(lon*1E6));
		
		mapController.animateTo(p);
		mapController.setZoom(12);
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
