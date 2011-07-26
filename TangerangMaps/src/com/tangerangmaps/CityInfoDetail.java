package com.tangerangmaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


import com.tangerangmaps.R;
import com.tangerangmaps.CityInfoDetail;
import com.tangerangmaps.ui.CityGuide;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

import greendroid.app.GDActivity;

public class CityInfoDetail extends GDActivity{
	
	int weblist;
	String title;
	WebView webview;
	@Override
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		
		title = getIntent().getStringExtra("title");
		
		setActionBarContentView(R.layout.cityinfodetail);
		setTitle(title);
		
		webview = (WebView) findViewById(R.id.cityinfodetail);
		weblist = getIntent().getIntExtra("weburl", R.raw.tentang);
		
		String content = loadStringFromRawResource(getResources(),weblist);

	        String mimeType = "text/html";
	        String encoding = "UTF-8";

	        //webview.loadUrl("file:///android_asset/info.html");
	        //webview.loadData(content, mimeType, encoding);
	        webview.loadDataWithBaseURL("file:///android_asset", content, mimeType, encoding, null);
	}

	public static String loadStringFromRawResource(Resources resources, int resId) {
		InputStream rawResource = resources.openRawResource(resId);
	    String content = streamToString(rawResource);
	    try {rawResource.close();} catch (IOException e) {}
		return content;
	}
	
	private static String streamToString(InputStream in) {
	    String l;
	    BufferedReader r = new BufferedReader(new InputStreamReader(in));
	    StringBuilder s = new StringBuilder();
	    try {
	        while ((l = r.readLine()) != null) {
	            s.append(l + "\n");
	        }
	    } catch (IOException e) {} 
	    return s.toString();
	}
	
	
	
}

