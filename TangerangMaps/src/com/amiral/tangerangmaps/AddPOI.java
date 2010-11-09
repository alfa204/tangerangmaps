package com.amiral.tangerangmaps;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddPOI extends Activity {

	private TextView lon;
	private TextView lat;
	private Button cekPeta;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addlocation);
		
		lat = (TextView) findViewById(R.id.label_latitude);
		lon = (TextView) findViewById(R.id.label_longitude);
		
		 Spinner kategori = (Spinner) findViewById(R.id.kategori);
		    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
		            this, R.array.list_kategori, android.R.layout.simple_spinner_item);
		    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    kategori.setAdapter(adapter);
	}
	
	public void lihatPeta(View tombol){
		Toast.makeText(getBaseContext(), "Diklik tampil PETA", Toast.LENGTH_SHORT).show();
		lat.setText("Latitude dari Peta");
		lon.setText("longitude dari Peta");
	}
	
	public void tambahLokasi(View tombol){
		Toast.makeText(getBaseContext(), "Tanda berhasil disimpan", Toast.LENGTH_SHORT).show();
	}
	
	
}
