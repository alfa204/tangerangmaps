/**
* Created by: Muhammad Amiral
* Feb 23, 2011
*/

package com.amiral.tangerangmaps;

import greendroid.app.GDApplication;

public class TangerangApplication extends GDApplication{
	public static final String APP_NAME = "TangerangMaps";
	
	  @Override
	public Class<?> getHomeActivityClass() {
	        return TangerangMapsMain.class;
	}
	  
	@Override
	public void onCreate(){
		super.onCreate();
//		this.dbHelper = new DBHelper(this);
	}
	
	@Override
	public void onTerminate(){
		super.onTerminate();
	}
	
}
