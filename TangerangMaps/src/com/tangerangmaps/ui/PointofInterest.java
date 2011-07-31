package com.tangerangmaps.ui;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.content.Context;
import com.tangerangmaps.R;
import com.tangerangmaps.ui.Categories.PoiSync;
import com.tangerangmaps.webservice.GetAllPOI;

import greendroid.app.GDActivity;

public class PointofInterest extends GDActivity{
	Context ctx;
	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		
		setActionBarContentView(R.layout.pointofinterest);
		setTitle("Point of Interest");
		ctx = this;
//		new PoiSync().execute();
	}
	
	public void btnEvent(View v){
		Intent i;
		
		switch (v.getId()) {
	
		case R.id.btnApotik:
			keList("1","Apotik", R.drawable.icon_apotik);
			break;
		case R.id.btnBank:
			keList("2","Bank", R.drawable.icon_bank);
			break;
		case R.id.btnHotel:
			keList("3","Hotel", R.drawable.icon_hotel);
			break;
		case R.id.btnKecamatan:
			keList("4","Kantor Kecamatan", R.drawable.iconkecamatan);
			break;
		case R.id.btnKelurahan:
			keList("5","Kantor Kelurahan", R.drawable.iconkelurahan);
			break;
		case R.id.btnLainlain:
			keList("6","Lain-lain", R.drawable.iconlainlain);
			break;
		case R.id.btnPasar:
			keList("7","Pasar Tradisional", R.drawable.iconpasar);
			break;
		case R.id.btnPolisi:
			keList("8","Kantor Polisi", R.drawable.iconpolisi);
			break;
		case R.id.btnPos:
			keList("9","Kantor Pos", R.drawable.iconpos);
			break;
		case R.id.btnPuskesmas:
			keList("10","Puskesmas", R.drawable.iconpuskesmas);
			break;
		case R.id.btnRS:
			keList("11","Rumah Sakit", R.drawable.iconrs);
			break;
		case R.id.btnSD:
			keList("12","SD", R.drawable.iconsd);
			break;
		case R.id.btnSMA:
			keList("13", "SMA", R.drawable.iconsma);
			break;
		case R.id.btnSMP:
			keList("14", "SMP", R.drawable.iconsmp);
			break;
		case R.id.btnSwalayan:
			keList("15", "Swalayan", R.drawable.iconswalayan);
			break;
		case R.id.btnTransportasi:
			keList("16", "Transportasi", R.drawable.icontransportasi);
			break;
		case R.id.btnPT:
			keList("17", "Perguruan Tinggi",R.drawable.iconuniversitas);
			break;
		case R.id.btnWisata:
			keList("18", "Objek Wisata",R.drawable.iconwisata);
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
				AlertDialog alertDialog = new AlertDialog.Builder(ctx)
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

