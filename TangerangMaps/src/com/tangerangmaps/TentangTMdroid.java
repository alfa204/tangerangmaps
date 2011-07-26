package com.tangerangmaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


import com.tangerangmaps.R;
import com.tangerangmaps.TentangTMdroid;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;

public class TentangTMdroid extends Activity{
	
	WebView webview;
	@Override
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		setContentView(R.layout.tentang_tm);
		
		webview = (WebView) findViewById(R.id.tentang_tm);
		
		 String content = loadStringFromRawResource(getResources(),R.raw.tentang);

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
	
	 //untuk mendeklarasikan Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	super.onCreateOptionsMenu(menu);
    	MenuInflater inflater= getMenuInflater();
    	inflater.inflate(R.menu.menu, menu);
    	
    	return true;
    }
    
    //Untuk mengeksekusi jika pilihan menu dipilih
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	super.onOptionsItemSelected(item);
    	switch (item.getItemId()) {
		case R.id.tentang_tm:
			startActivity(new Intent(this, TentangTMdroid.class));
			return true;
		}
    	return false;
    }
	
}
