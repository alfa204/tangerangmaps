package com.tangerangmaps.ui;

import greendroid.app.GDActivity;

import com.tangerangmaps.phonecalls;
import com.tangerangmaps.R;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import greendroid.app.GDActivity;

public class PhoneFire extends GDActivity{
    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		
        setActionBarContentView(R.layout.phonefire);
        setTitle("Fire Rescue");
    }
    public void btnEvent(View v){
		
		Intent i;
		switch (v.getId()) {
		
		case R.id.btnFire01:
			kePhone("tel:+62215984343");
			break;
		
		
			
		}
	}
	
    public void kePhone (String id){
    	Intent i = new Intent(this, phonecalls.class);
    	i.putExtra("listphone", id);
    	startActivity(i);
    }
}
      