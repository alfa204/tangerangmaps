package com.amiral.tangerangmaps;

import java.util.ArrayList;
import java.util.List;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.amiral.tangerangmaps.db.DBHelper;
import com.amiral.tangerangmaps.db.POIManager;
import com.amiral.tangerangmaps.object.PoiLokasi;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MapTangerang extends MapActivity {
	private MapView mapView;
	private MapController mapController;
	private GeoPoint p;
	
	private Context ctx;
	String kategori;
	String lat, lon, name, alamat;
	private List<PoiLokasi> lsPoi;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        ctx = this;
        lsPoi = new ArrayList<PoiLokasi>();
        
        mapView = (MapView) findViewById(R.id.maptangerang);
        kategori = getIntent().getStringExtra("kategori");
        Toast.makeText(this, "Kategori dipilih: "+kategori, Toast.LENGTH_SHORT).show();
        POIManager poiDb = new POIManager(ctx);
        lsPoi = poiDb.getPoiByKategori(kategori);
        poiDb.close();
        //Configure the map display options
		mapView.setStreetView(true);
		mapView.setBuiltInZoomControls(true);
		mapView.displayZoomControls(true);
		mapController = mapView.getController();
		
		for (int i = 0; i < lsPoi.size(); i++) {
			PoiLokasi poi = lsPoi.get(i);
			lat = poi.getLat();
			lon = poi.getLon();
			name = poi.getNama();
			alamat = poi.getAlamat();
			
			Log.i("coba", "Latitude ["+i+"] = "+lat);
			Log.i("coba", "Longitude ["+i+"] = "+lon);
			Log.i("coba", "Branch Name ["+i+"] = "+name);
			
			String coordinates[] = {lat, lon};
		        
		    double lati = Double.parseDouble(coordinates[0]);
		    double longi = Double.parseDouble(coordinates[1]);
		    
		    p = new GeoPoint((int) (lati * 1E6), (int) (longi * 1E6));
		    
		    List<Overlay> mapOverlays = mapView.getOverlays();
		    int draw = icon(kategori);
		    Drawable drawable = this.getResources().getDrawable(draw);
		    MapOverlay itemizedoverlay = new MapOverlay(drawable,ctx,lat, lon);
		    OverlayItem overlayitem = new OverlayItem(p, name, alamat);
	        itemizedoverlay.addOverlay(overlayitem);
		    mapOverlays.add(itemizedoverlay);
		}
		
		mapController.animateTo(p);
        mapController.setZoom(12); 
		
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
