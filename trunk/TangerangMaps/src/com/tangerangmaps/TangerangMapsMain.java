package com.tangerangmaps;

import java.util.List;

import com.tangerangmaps.R;
import com.tangerangmaps.adapter.IconAdapter;
import com.tangerangmaps.object.PoiIconItem;
import com.tangerangmaps.TentangTMdroid;
import com.tangerangmaps.ui.Categories;
import com.tangerangmaps.ui.CityGuide;
import com.tangerangmaps.ui.Keyphone;
import com.tangerangmaps.ui.NearByMap;
import com.tangerangmaps.ui.PointofInterest;
import com.tangerangmaps.util.GPSCallback;
import com.tangerangmaps.util.GPSManager;
import com.tangerangmaps.util.Utilities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import greendroid.app.GDActivity;
import greendroid.widget.ActionBarItem;
import greendroid.widget.ActionBarItem.Type;

public class TangerangMapsMain extends GDActivity implements GPSCallback{ //, GPSCallback
	
	private GPSManager gpsManager = null;
	private double userLon = 0;
	private double userLat = 0;
	SharedPreferences prefLocation;
	private LocationManager locationManager;
//	private Location location;
	private String bestProvider;
//	TextView tv;
	
	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
//		setContentView(R.layout.tangerangmaps_main);
		setActionBarContentView(R.layout.tangerangmaps_main);
		setTitleColor(R.color.lightblack);
//		tv = (TextView) findViewById(R.id.alamat);
		
		
		gpsManager = new GPSManager();
		gpsManager.startListening(this);
		gpsManager.setGPSCallback(this);
//		
//		locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
//		List<String> listProviders = locationManager.getAllProviders();
//		
//		Criteria criteria = new Criteria();
//		bestProvider = locationManager.getBestProvider(criteria, false);
//		location = locationManager.getLastKnownLocation(bestProvider);
//		
		addActionBarItem(Type.LocateMyself, R.id.action_bar_nearby);
		addActionBarItem(Type.Search,R.id.action_bar_search);
		
	}
	
	/*
	 * Untuk click handler
	 */
	public void eventClick(View v){
		
		Intent i;
		switch (v.getId()) {
		case R.id.btnCityInfo:
			i = new Intent(this, CityGuide.class);
			startActivity(i);
			break;
			
		case R.id.btnPoi:
			i = new Intent(this, Categories.class);
			startActivity(i);
			break;
		
		case R.id.btnPhone:
			i = new Intent(this, Keyphone.class);
			startActivity(i);
			break;
		}
	}
	
	@Override
	public void onGPSUpdate(Location location) {
		// TODO Auto-generated method stub
		getUserLocation(location);
	}
	
	public void getUserLocation(Location location){
		userLat = location.getLatitude();
		userLon = location.getLongitude();
		prefLocation = getSharedPreferences("tm", 0);
		String lat = Double.toString(userLat);
		String lon = Double.toString(userLon);
		Editor ed = prefLocation.edit();
		ed.putString("userLat", lat);
		ed.putString("userLon", lon);
		ed.commit();
//		String alamat = Utilities.goToGeocoder(this, userLat, userLon);
//		tv.setText("lat: "+lat + " Longi: "+ lon);
//		tv.setText(alamat);
	}

	@Override
	protected void onDestroy() {
		gpsManager.stopListening();
		gpsManager.setGPSCallback(null);
		
		gpsManager = null;
		
		super.onDestroy();
	}

	

	/*
	@Override
	public void onGPSUpdate(Location location) {
		// TODO Auto-generated method stub
		userLat = location.getLatitude();
		userLon = location.getLongitude();
		prefLocation = getSharedPreferences("tm", 0);
		String lat = Double.toString(userLat);
		String lon = Double.toString(userLon);
		Editor ed = prefLocation.edit();
		ed.putString("userLat", lat);
		ed.putString("userLon", lon);
		ed.commit();
		String alamat = Utilities.goToGeocoder(this, userLat, userLon);
		tv.setText(alamat);
	}
	
	@Override
	protected void onDestroy(){
		gpsManager.stopListening();
		gpsManager.setGPSCallback(null);
		
		gpsManager = null;
		
		super.onDestroy();
	}
	*/
	
	@Override
    public boolean onHandleActionBarItemClick(ActionBarItem item, int position) {
		switch (item.getItemId()) {
		case R.id.action_bar_nearby:
			startActivity(new Intent(this, NearByMap.class));
			break;

		default:
			break;
		}
		
		return true;
    }
	//untuk mendeklarasikan Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	super.onCreateOptionsMenu(menu);
    	MenuInflater inflater= getMenuInflater();
    	inflater.inflate(R.menu.menu, menu);
    	
    	return true;
    }
    
    //Untuk mengeksekusi jika pilihan menu dipilih
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	super.onOptionsItemSelected(item);
    	switch (item.getItemId()) {
		case R.id.tentang_menu:
			startActivity(new Intent(this, TentangTMdroid.class));
			return true;
		}
    	return false;
    }
}
