package com.tangerangmaps.ui;

import android.os.Bundle;

import com.tangerangmaps.R;

import greendroid.app.GDActivity;

public class Health extends GDActivity{

	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		
		setActionBarContentView(R.layout.health);
		setTitle("Health");
	}
}
