package com.amiral.tangerangmaps;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

public class TangerangMaps extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Menginisalisasi TAB
        TabHost host= getTabHost();
        TabHost.TabSpec tabSpec;
        Intent intent; //yang digunakan untuk memanggil tab lainnya
        
        intent = new Intent().setClass(this, Dashboard.class); //untuk inisialisasi tab pertama kali di jalankan
        tabSpec = host.newTabSpec("dasboard")
        		.setIndicator(
        				new Tampilan(this, R.drawable.kategori, R.string.tab_dashboard))
        				.setContent(intent);
        host.addTab(tabSpec);
        
        //tab Peta
        intent = new Intent().setClass(this, MapTangerang.class);
        tabSpec= host.newTabSpec("map")
        		.setIndicator(
        				new Tampilan(this, R.drawable.map, R.string.tab_map))
        				.setContent(intent);
        host.addTab(tabSpec);
       
        //tab Augmented Reality
        intent = new Intent().setClass(this, AugmentedReality.class);
        tabSpec= host.newTabSpec("augmentedreality")
        	.setIndicator(
        		new Tampilan(this, R.drawable.camera, R.string.tab_ar))
        		.setContent(intent);
        host.addTab(tabSpec);
        
        //tab Tambah lokasi
        intent = new Intent().setClass(this, AddPOI.class);
        tabSpec=host.newTabSpec("addpoi")
        		.setIndicator(
        				new Tampilan(this, R.drawable.tambah, R.string.tab_addlocation))
        				.setContent(intent);
        host.addTab(tabSpec);
    }
    
    private class Tampilan extends LinearLayout {

		public Tampilan(Context context, int gambar, int label) {
			super(context);
			// TODO Auto-generated constructor stub

			ImageView iv = new ImageView(context);
			TextView tv = new TextView(context);

			iv.setImageResource(gambar);
			tv.setText(label);
			tv.setGravity(0x01); // posisi ditengah

			setOrientation(LinearLayout.VERTICAL);
			addView(iv);
			addView(tv);

		}

	}
}