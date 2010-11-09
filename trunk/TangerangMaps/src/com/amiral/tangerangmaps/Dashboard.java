package com.amiral.tangerangmaps;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Dashboard extends Activity {

	@Override
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.dashboard);
	}
	
	public void pilihKategori(View tombol){
		switch (tombol.getId()) {
		case R.id.kategori_apotik:
			Toast.makeText(this, "Apotik dipilih", Toast.LENGTH_SHORT).show();
			break;
		case R.id.kategori_bank:
			Toast.makeText(this, "Bank dipilih",Toast.LENGTH_SHORT).show(); break;
		case R.id.kategori_hotel:
			Toast.makeText(this, "Hotel dipilih", Toast.LENGTH_SHORT).show(); break;
		case R.id.kategori_kecamatan:
			Toast.makeText(this, "Kecamatan dipilih", Toast.LENGTH_SHORT).show(); break;
		case R.id.kategori_kelurahan:
			Toast.makeText(this, "Kelurahan dipilih", Toast.LENGTH_SHORT).show(); break;
		case R.id.kategori_lain:
			Toast.makeText(this, "Lain-lain dipilih", Toast.LENGTH_SHORT).show(); break;
		case R.id.kategori_pasar:
			Toast.makeText(this, "Pasar dipilih", Toast.LENGTH_SHORT).show(); break;
		case R.id.kategori_polisi:
			Toast.makeText(this, "Polisi dipilih", Toast.LENGTH_SHORT).show(); break;
		case R.id.kategori_pos:
			Toast.makeText(this, "Kantor Pos dipilih", Toast.LENGTH_SHORT).show(); break;
		case R.id.kategori_puskesmas:
			Toast.makeText(this, "Puskesmas dipilih", Toast.LENGTH_SHORT).show(); break;
		case R.id.kategori_rumah_sakit:
			Toast.makeText(this, "Rumah Sakit dipilih", Toast.LENGTH_SHORT).show();break;
		case R.id.kategori_sd:
			Toast.makeText(this, "SD dipilih", Toast.LENGTH_SHORT).show(); break;
		case R.id.kategori_sma:
			Toast.makeText(this, "SMA dipilih", Toast.LENGTH_SHORT).show(); break;
		case R.id.kategori_smp:
			Toast.makeText(this, "SMP dipilih", Toast.LENGTH_SHORT).show(); break;
		case R.id.kategori_swalayan:
			Toast.makeText(this, "Swalayan dipilih", Toast.LENGTH_SHORT).show(); break;
		case R.id.kategori_transportasi:
			Toast.makeText(this, "Transportasi dipilih", Toast.LENGTH_SHORT).show(); break;
		case R.id.kategori_universitas:
			Toast.makeText(this, "Universitas dipilih", Toast.LENGTH_SHORT).show(); break;
		case R.id.kategori_wisata:
			Toast.makeText(this, "Object Wisata dipilih", Toast.LENGTH_SHORT).show(); break;
		default:
			break;
		}
	}

}
