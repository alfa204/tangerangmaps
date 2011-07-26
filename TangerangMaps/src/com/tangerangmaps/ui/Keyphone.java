package com.tangerangmaps.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tangerangmaps.R;

import greendroid.app.GDActivity;

public class Keyphone extends GDActivity{
	
	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		
		setActionBarContentView(R.layout.keyphone);
		setTitle("Key Telephone");
		
	}
	
	public void btnEvent(View v){
		switch (v.getId()) {
		case R.id.btn_phone_police:
			startActivity(new Intent(this, PhonePolice.class));
			break;
			
		case R.id.btn_phone_fire:
			startActivity(new Intent(this, PhoneFire.class));
			break;
		
		case R.id.btn_phone_health:
			startActivity(new Intent(this, PhoneHealth.class));
			break;
			
		case R.id.btn_phone_govern:
			startActivity(new Intent(this, PhoneGovernment.class));
			break;
		
		case R.id.btn_phone_pln:
			startActivity(new Intent(this, PhonePln.class));
			break;
		
		case R.id.btn_phone_pdam:
			startActivity(new Intent(this, PhonePdam.class));
			break;
			
		case R.id.btn_phone_telkom:
			startActivity(new Intent(this, PhoneTelkom.class));
			break;
			
		case R.id.btn_phone_public:
			startActivity(new Intent(this, PhonePublic.class));
			break;
			
		default:
			break;
		}
	}
}
