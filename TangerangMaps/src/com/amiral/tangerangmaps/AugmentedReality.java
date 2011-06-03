package com.amiral.tangerangmaps;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Text;

import com.amiral.tangerangmaps.db.*;
import com.amiral.tangerangmaps.object.PoiLokasi;
import com.amiral.tangerangmaps.util.LauncherLayar;
import com.amiral.tangerangmaps.webservice.GetAllPOI;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AugmentedReality extends Activity{
	
	TextView tv;
	Intent intent;
	Context context;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		context = this;
		setContentView(R.layout.augmentedreality);
		tv = (TextView) findViewById(R.id.tv);
	}
	
	public void panggilLayar(View tombol){
		intent=new Intent(this, LauncherLayar.class);
		startActivity(intent);
		finish();
		
	}
}
