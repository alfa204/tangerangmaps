package com.amiral.tangerangmaps.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoPoiDetailComment extends Activity{

	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		TextView tv = new TextView(this);
		
		tv.setText("Comment POI");
		setContentView(tv);
	}
}
