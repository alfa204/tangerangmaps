package com.tangerangmaps.ui;

import com.tangerangmaps.R;

import android.os.Bundle;
import greendroid.app.GDActivity;

public class Goverment extends GDActivity{

	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		
		setActionBarContentView(R.layout.goverment);
		setTitle("Goverment");
	}
}
