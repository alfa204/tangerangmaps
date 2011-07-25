package com.tangerangmaps;

import com.tangerangmaps.R;
import com.tangerangmaps.webservice.GetAllPOI;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Dashboard extends Activity {

	Context ctx;
	@Override
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.dashboard);
		ctx = this;
		
//		new PoiSync().execute();
	}
	
	public void pilihKategori(View tombol){
		switch (tombol.getId()) {
		case R.id.kategori_apotik:
			keMap("1");
			break;
		case R.id.kategori_bank:
			keMap("2");break;
		case R.id.kategori_hotel:
			keMap("3");break;
		case R.id.kategori_kecamatan:
			keMap("4");break;
		case R.id.kategori_kelurahan:
			keMap("5");break;
		case R.id.kategori_lain:
			keMap("6");break;
		case R.id.kategori_pasar:
			keMap("7");break;
		case R.id.kategori_polisi:
			keMap("8");break;
		case R.id.kategori_pos:
			keMap("9");break;
		case R.id.kategori_puskesmas:
			keMap("10");break;
		case R.id.kategori_rumah_sakit:
			keMap("11");break;
		case R.id.kategori_sd:
			keMap("12");break;
		case R.id.kategori_sma:
			keMap("13");break;
		case R.id.kategori_smp:
			keMap("14");break;
		case R.id.kategori_swalayan:
			keMap("15");break;
		case R.id.kategori_transportasi:
			keMap("16");break;
		case R.id.kategori_universitas:
			keMap("17");break;
		case R.id.kategori_wisata:
			keMap("18");break;
		default:
			break;
		}
	}
	
	public void keMap(String id){
		Intent i = new Intent(this, MapTangerang.class);
		i.putExtra("kategori", id);
		startActivity(i);
	}

	
	class PoiSync extends AsyncTask<Void, Void, Boolean>{

		private final ProgressDialog dialog = new ProgressDialog(ctx);

		protected void onPreExecute() {
			this.dialog.setMessage("Get Data from TangerangMaps.com, please wait...");
			this.dialog.show();
			Log.i("coba", "async start");
		}
		
		@Override
		protected Boolean doInBackground(Void... params) {
			// TODO Auto-generated method stub
			GetAllPOI getPoi = new GetAllPOI(ctx);
			
			return getPoi.getAllPoi();
		}
		
		protected void onPostExecute(Boolean result){
			if(result){
				dialog.hide();
				Toast.makeText(ctx, "Update Database Berhasil",
						Toast.LENGTH_LONG).show();
			}else{
				dialog.hide();
				AlertDialog alertDialog = new AlertDialog.Builder(getParent())
						.create();
				alertDialog.setTitle("Connection Error");
				alertDialog.setMessage("No connection detected");
				alertDialog.setButton("OK",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {

								// here you can add functions

							}
						});
				alertDialog.show();
			}
		}
	}
	
}
