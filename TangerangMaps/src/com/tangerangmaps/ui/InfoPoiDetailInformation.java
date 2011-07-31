package com.tangerangmaps.ui;

import greendroid.app.GDActivity;

import java.util.List;

import com.tangerangmaps.R;
import com.tangerangmaps.object.PoiLokasi;
import com.tangerangmaps.util.Utilities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoPoiDetailInformation extends Activity{

	PoiLokasi poi;
	
	TextView tvAlamat, tvTitle, tvTelp, tvFax, tvEmail,
		tvWeb, tvKet;
	
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
//		setContentView(R.layout.tangerangmaps_main);
		setContentView(R.layout.info_poi_detail_information);
		poi = (PoiLokasi) getIntent().getParcelableExtra("poi");
		
		tvAlamat = (TextView) findViewById(R.id.tvDetailAlamat);
		tvTelp = (TextView) findViewById(R.id.tvDetailTelepon);
		tvFax = (TextView) findViewById(R.id.tvDetailFax);
		tvEmail = (TextView) findViewById(R.id.tvDetailEmail);
		tvWeb = (TextView) findViewById(R.id.tvDetailWebsite);
		tvKet = (TextView) findViewById(R.id.tvDetailKet);
		
		tvAlamat.setText(poi.getAlamat());
		tvTelp.setText(poi.getTelp());
		tvFax.setText(poi.getFax());
		tvEmail.setText(poi.getEmail());
		tvWeb.setText(poi.getWebsite());
		tvKet.setText(poi.getKeterangan());
		
	}
}
