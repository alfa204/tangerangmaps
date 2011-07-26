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

public class PhonePolice extends GDActivity{
    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		
        setActionBarContentView(R.layout.phonepolice);
        setTitle("Police Office");
    }
    public void btnEvent(View v){
		
		Intent i;
		switch (v.getId()) {
		
		case R.id.btnPolisi01:
			kePhone("tel:+62215523003");
			break;
		
		case R.id.btnPolisi02:
			kePhone("tel:+62217201063");
			break;
		
		case R.id.btnPolisi03:
			kePhone("tel:+62215384139");
			break;
		
		case R.id.btnPolisi04:
			kePhone("tel:+62217492187");
			break;
		
		case R.id.btnPolisi05:
			kePhone("tel:+62217400110");
			break;
		
		case R.id.btnPolisi06:
			kePhone("tel:+62217315001");
			break;
		
		case R.id.btnPolisi07:
			kePhone("tel:+62215507393");
			break;
			
		}
	}
	
    public void kePhone (String id){
    	Intent i = new Intent(this, phonecalls.class);
    	i.putExtra("listphone", id);
    	startActivity(i);
    }
}
      