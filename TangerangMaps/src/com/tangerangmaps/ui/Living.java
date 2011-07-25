package com.tangerangmaps.ui;

import com.tangerangmaps.R;

import android.os.Bundle;
import greendroid.app.GDActivity;

public class Living extends GDActivity{
	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		
		setActionBarContentView(R.layout.living);
		setTitle(R.string.living);
	}
}
