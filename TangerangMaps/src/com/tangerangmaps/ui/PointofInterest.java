package com.tangerangmaps.ui;

import android.os.Bundle;

import com.tangerangmaps.R;

import greendroid.app.GDActivity;

public class PointofInterest extends GDActivity{
	
	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		
		setActionBarContentView(R.layout.pointofinterest);
		setTitle("Point of Interest");
		
	}
}
