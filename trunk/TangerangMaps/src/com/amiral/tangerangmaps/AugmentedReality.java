package com.amiral.tangerangmaps;

import com.amiral.tangerangmaps.util.LauncherLayar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AugmentedReality extends Activity{

	Intent intent;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.augmentedreality);
	}
	
	public void panggilLayar(View tombol){
		intent=new Intent(this, LauncherLayar.class);
		startActivity(intent);
		finish();
	}
}
