package com.amiral.tangerangmaps.ui;

import android.os.Bundle;

import com.amiral.tangerangmaps.R;

import greendroid.app.GDActivity;

public class Health extends GDActivity{

	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		
		setActionBarContentView(R.layout.health);
		setTitle("Health");
	}
}
