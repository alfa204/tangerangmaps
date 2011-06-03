package com.amiral.tangerangmaps.ui;

import com.amiral.tangerangmaps.R;

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
