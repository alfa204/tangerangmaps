package com.tangerangmaps.ui;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.tangerangmaps.MapOverlay;
import com.tangerangmaps.R;
import com.tangerangmaps.object.PoiLokasi;

public class InfoPoiDetailMap extends MapActivity{

	private MapView mapView;
	private PoiLokasi poi;
	private MapController mapController;
	private GeoPoint p;
	private int marker;
	String lat, lon, name, alamat;
	
	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		setContentView(R.layout.info_poi_detail_map);
		mapView = (MapView) findViewById(R.id.maptangerang);
		poi = (PoiLokasi) getIntent().getParcelableExtra("poi");
		marker = getIntent().getIntExtra("image", R.drawable.icon);
		
		 //Configure the map display options
		mapView.setStreetView(true);
		mapView.setBuiltInZoomControls(true);
		mapView.displayZoomControls(true);
		mapController = mapView.getController();
		
		lat = poi.getLat();
		lon = poi.getLon();
		name = poi.getNama();
		alamat = poi.getAlamat();
		String coordinates[] = {lat, lon};
        
	    double lati = Double.parseDouble(coordinates[0]);
	    double longi = Double.parseDouble(coordinates[1]);
	    
	    p = new GeoPoint((int) (lati * 1E6), (int) (longi * 1E6));
	    
	    List<Overlay> mapOverlays = mapView.getOverlays();
	    Drawable drawable = this.getResources().getDrawable(marker);
	    InfoPoiDetailMapOverlay itemizedoverlay = new InfoPoiDetailMapOverlay(drawable,this,lat, lon);
	    OverlayItem overlayitem = new OverlayItem(p, name, alamat);
        itemizedoverlay.addOverlay(overlayitem);
	    mapOverlays.add(itemizedoverlay);
	    
	    mapController.animateTo(p);
        mapController.setZoom(17); 
	}
	
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
