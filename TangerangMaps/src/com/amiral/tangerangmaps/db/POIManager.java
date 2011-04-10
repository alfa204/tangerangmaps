/**
* Created by: Muhammad Amiral
* Feb 19, 2011
*/

package com.amiral.tangerangmaps.db;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.sqlite.SQLiteDatabase;

public class POIManager extends ContextWrapper{
	private final String DATABASE_NAME = "TangerangMaps";
	private final String DATABASE_TABLE ="PoiLocation";
	SQLiteDatabase myDB = null;
	
	public String ID;
	public String idKategori;
	public String nama;
	public String alamat;
	public String idKecamatan;
	public String idKelurahan;
	public String telp;
	public String fax;
	public String email;
	public String website;
	public String keterangan;
	public String lat;
	public String lon;
	public String imageUrl;
	public String tanggalInput;
	
	public POIManager(Context base) {
		super(base);
		// TODO Auto-generated constructor stub
	}
	
	public void createTable(){
		myDB = this.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null);
		
		myDB.execSQL("CREATE TABLE IF NOT EXISTS "+ DATABASE_TABLE
				+ " ("+ ID + " INTEGER PRIMARY KEY, "
				+ idKategori + " INTEGER, "
				+ nama + " TEXT NOT NULL, "
				+ alamat + " TEXT NOT NULL, "
				+ idKecamatan + " TEXT, "
				+ idKelurahan + " TEXT, "
				+ telp + " TEXT, "
				+ fax + " TEXT, "
				+ email + " TEXT, "
				+ website + " TEXT, "
				+ keterangan + " TEXT, "
				+ imageUrl + " TEXT, "
				+ tanggalInput + " TIMESTAMP)");
	}

}
