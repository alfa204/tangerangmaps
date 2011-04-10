package com.amiral.tangerangmaps;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

import com.amiral.tangerangmaps.db.DBHelper;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class MapTangerang extends MapActivity {
	private MapView mapView;
	private MapController mapController;
	private GeoPoint p;
	
	private static int LOADING_DIALOG = 0;
	private boolean mShowDialog;
	private TangerangApplication myApp;
	private Context ctx;
	int categori;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        
        mapView = (MapView) findViewById(R.id.maptangerang);
        
        
		//Configure the map display options
		mapView.setStreetView(true);
		
//		LinearLayout zoomLayout=(LinearLayout) findViewById(R.id.zoom);
//		View zoomView=mapView.getZoomControls();
//		
//		zoomLayout.addView(zoomView,
//				new LinearLayout.LayoutParams(
//					LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
		mapView.setBuiltInZoomControls(true);
		mapView.displayZoomControls(true);
		mapController = mapView.getController();
		
		try{
			categori = 1;
			
			myApp = (TangerangApplication) MapTangerang.this.getApplication();
			DBHelper dbHelper = myApp.getDBHelper().getDBAdapterInstance(ctx);
			String query = "select lat, lon from t_poimanager " +
					"where IDKategori = '" + categori + "'";
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void onPrepareDialog(int id, Dialog dialog){
		super.onPrepareDialog(id, dialog);
		if(id == LOADING_DIALOG){
			mShowDialog = true;
		}
	}
	
	protected Dialog onCreateDialog(int id){
		if ( id == LOADING_DIALOG){
			ProgressDialog loadingDialog = new ProgressDialog(this);
			loadingDialog.setMessage("Loading Data...");
			loadingDialog.setIndeterminate(true);
			return loadingDialog;
		}
		return super.onCreateDialog(id);
	}
	

}
