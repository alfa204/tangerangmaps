package com.tangerangmaps.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tangerangmaps.CityInfoDetail;
import com.tangerangmaps.R;

import greendroid.app.GDActivity;

public class CityGuide extends GDActivity{
	
	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		
		setActionBarContentView(R.layout.cityguide);
		setTitle("City Information");
		
	}
	
	public void btnEvent(View v){
		Intent i;
		
		switch (v.getId()) {
		case R.id.btnCityinfo1:
			keUrl("Introduction", R.raw.introduction);
			break;
		case R.id.btnCityinfo2:
			keUrl("Understanding", R.raw.understanding);
			break;
		case R.id.btnCityinfo3:
			keUrl("Get In", R.raw.getin);
			break;
		case R.id.btnCityinfo4:
			keUrl("Get Around", R.raw.getaround);
			break;
		case R.id.btnCityinfo5:
			keUrl("Do", R.raw.doing);
			break;
		case R.id.btnCityinfo6:
			keUrl("Shop", R.raw.shop);
			break;
		case R.id.btnCityinfo7:
			keUrl("Eat", R.raw.eating);
			break;
		case R.id.btnCityinfo8:
			keUrl("Sleep", R.raw.sleep);
			break;
		default:
			break;
		}
	}

	
	public void keUrl(String Title, int web){
		Intent i = new Intent (this, CityInfoDetail.class);
		i.putExtra("title", Title);
		i.putExtra("weburl", web);
		startActivity(i);
	}
	
	}

