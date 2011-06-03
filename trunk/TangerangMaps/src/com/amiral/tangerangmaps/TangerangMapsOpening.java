package com.amiral.tangerangmaps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class TangerangMapsOpening extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.opening);
		
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
