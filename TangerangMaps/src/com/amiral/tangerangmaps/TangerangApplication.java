/**
* Created by: Muhammad Amiral
* Feb 23, 2011
*/

package com.amiral.tangerangmaps;

import java.io.IOException;

import com.amiral.tangerangmaps.db.DBHelper;

import android.app.Application;

public class TangerangApplication extends Application{
	public static final String APP_NAME = "TangerangMaps";
	private DBHelper dbHelper;
	@Override
	public void onCreate(){
		super.onCreate();
		this.dbHelper = new DBHelper(this);
	}
	
	@Override
	public void onTerminate(){
		super.onTerminate();
	}
	
	public DBHelper getDBHelper(){
		try{
			dbHelper.createDataBase();
		}catch (IOException e) {
			// TODO: handle exception
			throw new Error("Unable to create database");
		}
		return this.dbHelper;
	}
	
}
