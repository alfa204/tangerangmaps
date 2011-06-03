/**
* Created by: Muhammad Amiral
* Feb 19, 2011
*/

package com.amiral.tangerangmaps.db;

import java.util.ArrayList;
import java.util.List;

import com.amiral.tangerangmaps.object.PoiLokasi;

import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class POIManager extends ContextWrapper{
	private final String DATABASE_NAME = "tangerangmapsdb";
	private final String DATABASE_TABLE ="lokasi";
	SQLiteDatabase myDB = null;
	
	public static String ID = "id_lokasi";
	public static String idKategori = "id_kategori";
	public String nama = "nama";
	public String alamat = "alamat";
	public String idKecamatan = "id_kec";
	public String idKelurahan = "id_kel";
	public String telp = "telp";
	public String fax = "fax";
	public String email= "email";
	public String website = "website";
	public String keterangan = "keterangan";
	public String lat = "lat";
	public String lon = "lng";
	public String imageUrl = "image";
	public String tanggalInput = "tgl_input";
	public String kontribName = "kontrib_nama";
	public String kontribEmail = "kontrib_email";
	
	public POIManager(Context base) {
		super(base);
		// TODO Auto-generated constructor stub
		createTable();
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
				+ lat + " TEXT, "
				+ lon + " TEXT, "
				+ imageUrl + " TEXT, "
				+ tanggalInput + " TIMESTAMP,"
				+ kontribName + " TEXT, "
				+ kontribEmail + " TEXT);");
		
		Log.i("tm", "table created");
	}
	
	public void insertPoi(PoiLokasi poi){
		
		/*ContentValues cv = new ContentValues();
		
		cv.put(idKategori, poi.getIdKategori());
		cv.put(nama, poi.getNama());
		cv.put(alamat, poi.getAlamat());
		cv.put(idKecamatan, poi.getIdKecamatan());
		cv.put(idKelurahan, poi.getIdKelurahan());
		cv.put(telp, poi.getTelp());
		cv.put(fax, poi.getFax());
		cv.put(email, poi.getEmail());
		cv.put(website, poi.getWebsite());
		cv.put(keterangan, poi.getKeterangan());
		cv.put(lat, poi.getLat());
		cv.put(lon, poi.getLon());
		cv.put(imageUrl, poi.getImageUrl());
		cv.put(tanggalInput, poi.getTanggalInput());
		cv.put(kontribName, poi.getKontribName());
		cv.put(kontribEmail, poi.getKontribEMail());
		*/
//		Log.i("tm", "Poi input database: " + cv.toString());
		
		try{
//			myDB.insert(DATABASE_TABLE, null, cv);
			String query = "INSERT INTO " + DATABASE_TABLE
			+ "(id_kategori, nama, alamat,id_kec,id_kel,telp," +
					"fax,email,website,keterangan,lat,lng,image," +
					"tgl_input,kontrib_nama,kontrib_email)" +
					" VALUES ('"
					+ poi.getIdKategori()+ "','"
					+ poi.getNama()+ "','"
					+ poi.getAlamat()+ "','"
					+ poi.getIdKecamatan()+ "','"
					+ poi.getIdKelurahan()+ "','"
					+ poi.getTelp()+ "','"
					+ poi.getFax()+ "','"
					+ poi.getEmail()+ "','"
					+ poi.getWebsite()+ "','"
					+ poi.getKeterangan()+ "','"
					+ poi.getLat()+ "','"
					+ poi.getLon()+ "','"
					+ poi.getImageUrl()+ "','"
					+ poi.getTanggalInput()+ "','"
					+ poi.getKontribName()+ "','"
					+ poi.getKontribEMail()+ "');";
					
			myDB.execSQL(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	
	public List<PoiLokasi> getPoiByKategori(String id){
		List<PoiLokasi> pois = new ArrayList<PoiLokasi>();
		String query = "select * from lokasi where id_kategori='"+id+"'";
		Cursor c = myDB.rawQuery(query, null);
		
		while(c.moveToNext()){
			PoiLokasi poi = new PoiLokasi();
			poi.setAlamat(c.getString(c.getColumnIndex(alamat)));
			poi.setEmail(c.getString(c.getColumnIndex(email)));
			poi.setFax(c.getString(c.getColumnIndex(fax)));
			poi.setImageUrl(c.getString(c.getColumnIndex(imageUrl)));
			poi.setKeterangan(c.getString(c.getColumnIndex(keterangan)));
			poi.setKontribEMail(c.getString(c.getColumnIndex(kontribEmail)));
			poi.setKontribName(c.getString(c.getColumnIndex(kontribName)));
			poi.setLat(c.getString(c.getColumnIndex(lat)));
			poi.setLon(c.getString(c.getColumnIndex(lon)));
			poi.setNama(c.getString(c.getColumnIndex(nama)));
			poi.setTelp(c.getString(c.getColumnIndex(telp)));
			poi.setWebsite(c.getString(c.getColumnIndex(website)));
			pois.add(poi);
		}
		c.close();
		c = null;
		
		return pois;
	}
	public void close() {
		myDB.close();
	}
	
	public void removeall() {
		myDB.execSQL("DELETE FROM  " + DATABASE_TABLE + ";");
		Log.i("tv", "records deleted successfully ");
	}

}
