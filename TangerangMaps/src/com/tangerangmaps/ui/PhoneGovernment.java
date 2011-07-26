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

public class PhoneGovernment extends GDActivity{
    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		
        setActionBarContentView(R.layout.phonegovernment);
        setTitle("Government");
    }
    public void btnEvent(View v){
		
		Intent i;
		switch (v.getId()) {
		
		case R.id.btnGovern01:
			kePhone("tel:+622155764955");
			break;
		
		case R.id.btnGovern02:
			kePhone("tel:+62215995529");
			break;
		
		case R.id.btnGovern03:
			kePhone("tel:+622174718008");
			break;
		
		case R.id.btnGovern04:
			kePhone("tel:+62215524157");
			break;
		
		case R.id.btnGovern05:
			kePhone("tel:+622155797606");
			break;
		
			
		}
	}
	
    public void kePhone (String id){
    	Intent i = new Intent(this, phonecalls.class);
    	i.putExtra("listphone", id);
    	startActivity(i);
    }
}
      