package com.amiral.tangerangmaps.ui;

import java.util.ArrayList;
import java.util.List;

import com.amiral.tangerangmaps.R;
import com.amiral.tangerangmaps.adapter.ListPoiAdapter;
import com.amiral.tangerangmaps.db.POIManager;
import com.amiral.tangerangmaps.object.PoiLokasi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import greendroid.app.GDActivity;

public class ListPoi extends GDActivity implements OnItemClickListener{

	ListView listPoi;
	List<PoiLokasi> pois;
	Context ctx;
	String kategori,title;
	int imgRes;
	
	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		ctx = this;
		
		setActionBarContentView(R.layout.list_poi);
		listPoi = (ListView) findViewById(R.id.listPoi);
		listPoi.setClickable(true);
		listPoi.setFocusable(true);
		listPoi.setTextFilterEnabled(true);
		
		kategori = getIntent().getStringExtra("kategori");
		title = getIntent().getStringExtra("title");
		imgRes = getIntent().getIntExtra("image", R.drawable.icon);
		
		setTitle(title);
		POIManager poiDb = new POIManager(ctx);
        pois = poiDb.getPoiByKategori(kategori);
        poiDb.close();
        
		ListPoiAdapter adapter = new ListPoiAdapter(this, pois, imgRes);
		listPoi.setAdapter(adapter);
		listPoi.setOnItemClickListener(this);
		pois = new ArrayList<PoiLokasi>();
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int index, long arg3) {
		// TODO Auto-generated method stub
		PoiLokasi poi = (PoiLokasi) listPoi.getItemAtPosition(index);
		
		Intent i = new Intent(v.getContext(), InfoPoiDetail.class);
		i.putExtra("poi", poi);
		i.putExtra("image", imgRes);
		startActivity(i);
	}
}
