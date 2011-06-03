package com.amiral.tangerangmaps;

import com.amiral.tangerangmaps.adapter.IconAdapter;
import com.amiral.tangerangmaps.object.PoiIconItem;
import com.amiral.tangerangmaps.ui.Education;
import com.amiral.tangerangmaps.ui.Goverment;
import com.amiral.tangerangmaps.ui.Health;
import com.amiral.tangerangmaps.ui.Living;
import com.amiral.tangerangmaps.ui.Transportation;
import com.amiral.tangerangmaps.webservice.GetAllPOI;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import greendroid.app.GDActivity;
import greendroid.widget.ActionBarItem.Type;

public class Categories extends GDActivity{

	Context ctx;
	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		setActionBarContentView(R.layout.categories);
		setTitle("Categories");
		ctx = this;
		
//		new PoiSync().execute();
		
		int witdhScreen =  getWindow().getWindowManager().getDefaultDisplay().getWidth();
		int column = getColumn(witdhScreen);
		
		/*GridView gridView = (GridView) findViewById(R.id.gridCategories);
		gridView.setNumColumns(column);
		
		IconAdapter adapter = new IconAdapter(this, 
			new PoiIconItem(R.string.street, R.drawable.street),
			new PoiIconItem(R.string.gov, R.drawable.btn_goverment),
			new PoiIconItem(R.string.edu, R.drawable.education),
			new PoiIconItem(R.string.health, R.drawable.health),
			new PoiIconItem(R.string.living, R.drawable.living),
			new PoiIconItem(R.string.transportation, R.drawable.transportation),
			new PoiIconItem(R.string.bank, R.drawable.bank),
			new PoiIconItem(R.string.shopping, R.drawable.shopping),
			new PoiIconItem(R.string.culinary, R.drawable.culinary),
			new PoiIconItem(R.string.sport, R.drawable.sport),
			new PoiIconItem(R.string.travel, R.drawable.travel),
			new PoiIconItem(R.string.entertaiment, R.drawable.entertaiment),
			new PoiIconItem(R.string.service, R.drawable.public_service),
			new PoiIconItem(R.string.facility, R.drawable.public_facility));
			
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(this);
		*/
		addActionBarItem(Type.LocateMyself, R.id.action_bar_nearby);
		addActionBarItem(Type.Search,R.id.action_bar_search);
	}
	
	public int getColumn(int withScreen){
		int column =2;
		if(withScreen == 800 || withScreen == 600){
			column = 3;
		}else{
			column = 2;
		}
		
		return column;
	}

	public void btnEvent(View v){
		switch (v.getId()) {
		case R.id.btnGoverment:
			startActivity(new Intent(this, Goverment.class));
			break;
		case R.id.btnEducation:
			startActivity(new Intent(this, Education.class));
			break;
		case R.id.btnHealth:
			startActivity(new Intent(this, Health.class));
			break;
		case R.id.btnLiving:
			startActivity(new Intent(this, Living.class));
			break;
		case R.id.btnTransportation:
			startActivity(new Intent(this, Transportation.class));
			break;
		default:
			break;
		}
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
