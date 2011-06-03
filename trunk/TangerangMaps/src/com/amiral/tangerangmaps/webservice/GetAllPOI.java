package com.amiral.tangerangmaps.webservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.amiral.tangerangmaps.db.POIManager;
import com.amiral.tangerangmaps.object.PoiLokasi;

public class GetAllPOI {

//	private static final String SERVER_URL="http://10.0.2.2/json.php";
//	private static final String SERVER_URL="http://10.162.51.128/json.php";
	private static final String SERVER_URL="http://tangerangmaps.com/json.php";
	Context context;
	
	public GetAllPOI(Context mContext){
		this.context = mContext;
	}
	
	public boolean getAllPoi(){
		
		boolean result = false;
		JSONObject j = new JSONObject();
		POIManager db = new POIManager(context);
		
		try{
			HttpResponse re = HTTPPost.doPost(SERVER_URL, j);
			String temp = EntityUtils.toString(re.getEntity());
			
			JSONArray jArr = new JSONArray(temp);
			
			int counter = jArr.length();
			if (counter != 0) {
				result = true;
				db.removeall();
				Log.i("coba", "hapus databases");
				for (int i = 0; i < counter; i++) {
					JSONObject jO = jArr.getJSONObject(i);
					
					PoiLokasi poi = new  PoiLokasi();
					
					poi.setID(jO.getString("id_lokasi"));
					poi.setIdKategori(jO.getString("id_kategori"));
					poi.setNama(jO.getString("nama"));
					poi.setAlamat(jO.getString("alamat"));
					poi.setIdKecamatan(jO.getString("id_kec"));
					poi.setTelp(jO.getString("telp"));
					poi.setFax(jO.getString("fax"));
					poi.setEmail(jO.getString("email"));
					poi.setWebsite(jO.getString("website"));
					poi.setKeterangan(jO.getString("keterangan"));
					poi.setLat(jO.getString("lat"));
					poi.setLon(jO.getString("lng"));
					poi.setImageUrl(jO.getString("image"));
					poi.setTanggalInput(jO.getString("tgl_input"));
					poi.setKontribName(jO.getString("kontrib_nama"));
					poi.setKontribEMail(jO.getString("kontrib_email"));
					db.insertPoi(poi);
					Log.i("coba", "Yang di ambil: Nama : "+ poi.getNama() + " Alamat: "+ poi.getAlamat());
					
				}
			}else{
				result = false;
			}
			
			
		}catch(ClientProtocolException e){
	        Log.e("request error",e.getMessage());
	    } catch(IOException e){
	        Log.e("requset error",e.getMessage());
	    } catch (JSONException e) {
	    	Log.e("json error",e.getMessage());
	    }
	    db.close();
		return result;
		
	}
}
