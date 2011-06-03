package com.amiral.tangerangmaps;

import com.amiral.tangerangmaps.adapter.IconAdapter;
import com.amiral.tangerangmaps.object.PoiIconItem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import greendroid.app.GDActivity;
import greendroid.widget.ActionBarItem.Type;

public class TangerangMapsMain extends GDActivity implements OnItemClickListener{
	
	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
//		setContentView(R.layout.tangerangmaps_main);
		setActionBarContentView(R.layout.tangerangmaps_main);
		setTitleColor(R.color.lightblack);
		GridView gridView = (GridView) findViewById(R.id.grid);
		
		gridView.setAdapter(new IconAdapter(this, 
				new PoiIconItem(R.string.aboutTangerang, R.drawable.gov90),
				new PoiIconItem(R.string.categories, R.drawable.map),
				new PoiIconItem(R.string.transportRoute, R.drawable.transportation),
				new PoiIconItem(R.string.liveView, R.drawable.camera),
				new PoiIconItem(R.string.keyTelephone, R.drawable.tab_icon_news)));
		
		gridView.setOnItemClickListener(this);
		addActionBarItem(Type.LocateMyself, R.id.action_bar_nearby);
		addActionBarItem(Type.Search,R.id.action_bar_search);
		
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int index, long arg3) {
		// TODO Auto-generated method stub
		switch (index) {
		case 0:
//			Toast.makeText(this, "About Tangerang", Toast.LENGTH_LONG).show();
			startActivity(new Intent(v.getContext(), Dashboard.class));
			break;
		case 1:
			startActivity(new Intent(this, Categories.class));
		default:
			Toast.makeText(this, "COba", Toast.LENGTH_LONG).show();
			break;
		}
	}
}
