package com.tangerangmaps.adapter;

import java.util.List;

import com.tangerangmaps.R;
import com.tangerangmaps.object.PoiLokasi;
import com.tangerangmaps.util.Utilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListPoiAdapter extends BaseAdapter{

	private Context ctx;
	private List<PoiLokasi> pois;
	private int imgIcon;
	
	public ListPoiAdapter(Context ctx, List<PoiLokasi> poises, int image) {
		super();
		this.ctx = ctx;
		this.pois = poises;
		this.imgIcon = image;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return pois.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return pois.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		PoiLokasi poi = pois.get(position);
		
		// TODO Auto-generated method stub
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.list_poi_item, null);
		}
		ImageView img = (ImageView) convertView.findViewById(R.id.imgIcon);
		img.setImageResource(imgIcon);
		
		TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
		tvTitle.setText(poi.getNama());
		TextView tvDesc = (TextView) convertView.findViewById(R.id.tvAlamat);
		tvDesc.setText(poi.getAlamat());
		
		TextView tvJarak = (TextView) convertView.findViewById(R.id.tvJarak);
		double jarak = Utilities.RoundDecimal(poi.getJarak(), 2);
		tvJarak.setText(""+ jarak + " Km");
		return convertView;
	}

}
