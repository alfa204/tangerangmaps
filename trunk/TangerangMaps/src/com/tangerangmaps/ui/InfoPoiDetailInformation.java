package com.tangerangmaps.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoPoiDetailInformation extends Activity{

	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		TextView tv = new TextView(this);
		
		tv.setText("Information POI");
		setContentView(tv);
	}
}
