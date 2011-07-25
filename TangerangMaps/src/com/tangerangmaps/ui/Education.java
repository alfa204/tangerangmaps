package com.tangerangmaps.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tangerangmaps.MapTangerang;
import com.tangerangmaps.R;

import greendroid.app.GDActivity;

public class Education extends GDActivity{
	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		
		setActionBarContentView(R.layout.education);
		setTitle(R.string.edu);
		
	}
	
	public void eventEdu(View v){
		Intent i;
		
		switch (v.getId()) {
		case R.id.btnSd:
			keList("12","Sekolah Dasar", R.drawable.iconsd);
			break;
		case R.id.btnSmp:
			keList("14", "SMP", R.drawable.iconsmp);
			break;
		case R.id.btnSma:
			keList("13", "SMA", R.drawable.iconsma);
			break;
		case R.id.btnUniversitas:
			keList("17", "Universitas",R.drawable.iconuniversitas);
			break;
		default:
			break;
		}
	}
	
	public void keList(String id, String title, int img){
		Intent i = new Intent(this, ListPoi.class);
		i.putExtra("kategori", id);
		i.putExtra("title", title);
		i.putExtra("image", img);
		startActivity(i);
	}
}
