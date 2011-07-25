package com.tangerangmaps;

import com.tangerangmaps.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class TangerangMapsOpening extends Activity {

	private LocationManager locMan;
	private LocationListener locLis;
	Location lastLocation = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.opening);
		
		locMan = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		/** Mengatur waktu tampil */
		final int lamaTampil = 3000;
		
			Thread openingThread = new Thread(){
				int tunggu = 0;
				
				@Override
				public void run(){
				try{
					super.run();
					/**
					 * Mencek setiap waktu dengan while menggunakan sleep()
					 * untuk menambahkan waktu tunggu
					 */
					while(tunggu <lamaTampil ){
						sleep(100);
						tunggu +=100;
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error : "+ e);
				} finally{
					/**
					 * jika telah selesai maka baru di panggil activiy utama
					 */
					startActivity(new Intent(TangerangMapsOpening.this,TangerangMapsMain.class));
					finish();
				}
			}
		};
		openingThread.start();
	}
}
