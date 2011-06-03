package com.amiral.tangerangmaps;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import greendroid.app.GDTabActivity;

public class TangerangMaps extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Tampilan myTampilan = null;
        Drawable d = this.getResources().getDrawable(R.drawable.tabbackground);
        //Menginisalisasi TAB
        TabHost host= getTabHost();
        TabHost.TabSpec tabSpec;
        Intent intent; //yang digunakan untuk memanggil tab lainnya
        
        intent = new Intent().setClass(this, Dashboard.class); //untuk inisialisasi tab pertama kali di jalankan
        myTampilan = new Tampilan(this, R.drawable.kategori,R.drawable.kategori, R.string.tab_dashboard);
        myTampilan.setBackgroundDrawable(d);
        tabSpec = host.newTabSpec("dasboard")
        		.setIndicator(myTampilan).setContent(intent);
        host.addTab(tabSpec);
//        addTabSpect(tabSpec);
        
        //tab Peta
        intent = new Intent().setClass(this, MapTangerang.class);
        myTampilan = new Tampilan(this, R.drawable.map, R.drawable.map, R.string.tab_map);
        myTampilan.setBackgroundDrawable(d);
        tabSpec= host.newTabSpec("map")
        		.setIndicator(myTampilan).setContent(intent);
//        addTabSpect(tabSpec);
        host.addTab(tabSpec);
       
        //tab Augmented Reality
        intent = new Intent().setClass(this, AugmentedReality.class);
        myTampilan = new Tampilan(this, R.drawable.camera, R.drawable.camera, R.string.tab_ar);
        myTampilan.setFocusable(true);
        myTampilan.setBackgroundDrawable(d);
        tabSpec= host.newTabSpec("augmentedreality")
        	.setIndicator(myTampilan)
        		.setContent(intent);
        host.addTab(tabSpec);
        
        //tab News
        intent = new Intent().setClass(this, News.class);
        myTampilan = new Tampilan(this, R.drawable.tab_icon_news, R.drawable.tab_icon_news, R.string.tab_news);
        myTampilan.setFocusable(true);
        myTampilan.setBackgroundDrawable(d);
        tabSpec= host.newTabSpec("news")
        	.setIndicator(myTampilan)
        		.setContent(intent);
        host.addTab(tabSpec);
//        addTabSpect(tabSpec);
        
        //tab Tambah lokasi
        intent = new Intent().setClass(this, AddPOI.class);
        myTampilan = new Tampilan(this, R.drawable.tambah, R.drawable.tambah, R.string.tab_addlocation);
        myTampilan.setFocusable(true);
        myTampilan.setBackgroundDrawable(d);
        tabSpec=host.newTabSpec("addpoi")
        		.setIndicator(myTampilan)
        				.setContent(intent);
        host.addTab(tabSpec);
//        addTabSpect(tabSpec);
    }
    
    private class Tampilan extends LinearLayout {
    	ImageView iv;
    	TextView tv;
		public Tampilan(Context context, int gambar, int gambarFocus, int label) {
			super(context);
			// TODO Auto-generated constructor stub

			iv = new ImageView(context);
			
			StateListDrawable listDrawable = new StateListDrawable();
			listDrawable.addState(SELECTED_STATE_SET, this.getResources()
					.getDrawable(gambarFocus));
			listDrawable.addState(ENABLED_STATE_SET, this.getResources()
					.getDrawable(gambar));
			
			iv.setImageDrawable(listDrawable);
			iv.setBackgroundColor(Color.TRANSPARENT);
			
			//untuk menyesuaikan tampilan tab dengan ukuran layar
			int lebarLayar = getWindow().getWindowManager()
			.getDefaultDisplay().getWidth();
			
			if (lebarLayar==800)
			{
				//Honeycomb
				iv.setLayoutParams(new LayoutParams(64, 64, (float) 20.0));
			}
			else if (lebarLayar==600)
			{
				//GalaxyTab
				iv.setLayoutParams(new LayoutParams(58, 58, (float) 20.0));
			}
			else if (lebarLayar==480)
			{
				//Nexus S
				iv.setLayoutParams(new LayoutParams(49, 49, (float) 20.0));
			}
			else if(lebarLayar==320)
			{
				//HTC Hero
				iv.setLayoutParams(new LayoutParams(33, 33, (float) 20.0));
			}
			else if(lebarLayar==240)
			{
				//Galaxy Mini
				iv.setLayoutParams(new LayoutParams(24, 24, (float) 20.0));
			}
			else
			{
				//Diatas Xoom
				iv.setLayoutParams(new LayoutParams(68, 68, (float) 20.0));
			}
			
			setGravity(Gravity.CENTER);
			
			tv = new TextView(context);
			tv.setText(label);
//			tv.setGravity(0x01); // posisi ditengah
			tv.setGravity(Gravity.BOTTOM);
			tv.setBackgroundColor(Color.TRANSPARENT);
			tv.setTextColor(Color.WHITE);
			tv.setTextSize(12);
			
			tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT, (float) 1.0));
			setOrientation(LinearLayout.VERTICAL);
			addView(iv);
			addView(tv);
			setBackgroundDrawable(this.getResources().getDrawable(R.drawable.tabbackground));
		}

	}
}