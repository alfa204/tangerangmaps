package com.tangerangmaps.ui;

import java.util.Iterator;
import java.util.List;

import greendroid.app.GDMapActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.tangerangmaps.MapOverlay;
import com.tangerangmaps.R;
import com.tangerangmaps.adapter.CustomOverlayItem;
import com.tangerangmaps.db.POIManager;
import com.tangerangmaps.object.PoiLokasi;

public class NearByMap extends GDMapActivity{

	MapView mapView;
	Context mContext;	
	String lat, lon, name, alamat, kategori;
	SharedPreferences prefLocation;
	List<PoiLokasi> pois;
	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		setActionBarContentView(R.layout.map_near_by);
		mContext = this;
		setTitle("Lokasi dalam radius 3 KM");
		
		POIManager poiDb = new POIManager(this);
		pois = poiDb.getNearPoi();
		
		initMap();
		drawMarker();
	}
	
	private void initMap(){
		mapView = (MapView) findViewById(R.id.mapNearby);
		mapView.setBuiltInZoomControls(true);
		mapView.getController().setZoom(15);
	}
	
	private void drawMarker(){
		List<Overlay> overlays = mapView.getOverlays();
		
		prefLocation = getSharedPreferences("tm", 0);
		double latUser = Double.parseDouble(prefLocation.getString("userLat", "0"));
		double lonUser = Double.parseDouble(prefLocation.getString("userLon", "0"));
		
		//untuk menghapus overlay yang lama
		if(overlays.size() > 0){
			for (Iterator iterator= overlays.iterator(); iterator.hasNext();) {
				iterator.hasNext();
				iterator.remove();
			}
		}
		
		// transform the location to a geopoint
		GeoPoint geopoint = new GeoPoint(
				(int) (latUser * 1E6), (int) (lonUser * 1E6));
		GeoPoint myposition = geopoint;
		Drawable icon = getResources().getDrawable(R.drawable.my_location);
		icon.setBounds(0, 0, icon.getIntrinsicWidth(), icon
				.getIntrinsicHeight());

		// Marker lokasi user
		MapOverlay overlay = new MapOverlay(icon, this, prefLocation.getString("userLat", "0"), prefLocation.getString("userLon", "0"));
		OverlayItem item = new OverlayItem(geopoint, "My Location", "Lat:"
				+ latUser + "\nLng:" + lonUser);
		overlay.addOverlay(item);
		overlays.add(overlay);
		
		for (int i = 0; i < pois.size(); i++) {
			PoiLokasi poi = pois.get(i);
			lat = poi.getLat();
			lon = poi.getLon();
			name = poi.getNama();
			alamat = poi.getAlamat();
			kategori = poi.getIdKategori();
			

			String coordinates[] = {lat, lon};
		        
		    double lati = Double.parseDouble(coordinates[0]);
		    double longi = Double.parseDouble(coordinates[1]);
		    
		    GeoPoint p = new GeoPoint((int) (lati * 1E6), (int) (longi * 1E6));
		    int draw = icon(kategori);
		    Drawable drawable = this.getResources().getDrawable(draw);
		    MapOverlay itemizedoverlay = new MapOverlay(drawable,this,poi);
		    OverlayItem overlayitem = new OverlayItem(p, name, alamat);
	        itemizedoverlay.addOverlay(overlayitem);
	        overlays.add(itemizedoverlay);
		}
		
		
		
		// move to location
		mapView.getController().animateTo(myposition);

		// redraw map
		mapView.postInvalidate();

	}
	
	public int icon(String kategori){
		int a = Integer.parseInt(kategori);
	    int draw = 0;
	    switch (a) {
		case 1:
			draw = R.drawable.icon_apotik;break;
		case 2:
			draw = R.drawable.icon_bank;break;
		case 3:
			draw = R.drawable.icon_hotel;break;
		case 4:
			draw = R.drawable.iconkecamatan;break;
		case 5:
			draw = R.drawable.iconkelurahan;break;
		case 6:
			draw = R.drawable.iconlainlain;break;
		case 7:
			draw = R.drawable.iconpasar;break;
		case 8:
			draw = R.drawable.iconpolisi;break;
		case 9:
			draw = R.drawable.iconpos;break;
		case 10:
			draw = R.drawable.iconpuskesmas;break;
		case 11:
			draw = R.drawable.iconrs;break;
		case 12:
			draw = R.drawable.iconsd;break;
		case 13:
			draw = R.drawable.iconsma;break;
		case 14:
			draw = R.drawable.iconsmp;break;
		case 15:
			draw = R.drawable.iconswalayan;break;
		case 16:
			draw = R.drawable.icontransportasi;break;
		case 17:
			draw = R.drawable.iconuniversitas;break;
		case 18:
			draw = R.drawable.iconwisata;break;
		default:
			break;
		}
	    
	    return draw;
	}
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
