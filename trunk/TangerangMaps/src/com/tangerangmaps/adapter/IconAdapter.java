package com.tangerangmaps.adapter;

import com.tangerangmaps.R;
import com.tangerangmaps.object.PoiIconItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class IconAdapter extends BaseAdapter{

	private final PoiIconItem[] icons;
	private Context ctx;
	
	public IconAdapter(Context context, PoiIconItem... icons) {
		super();
		this.icons = icons;
		this.ctx = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return icons.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return icons[arg0];
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		// TODO Auto-generated method stub
		if(view == null){
			LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.icon, null);
		}
		PoiIconItem icon = icons[position];
		ImageView image = (ImageView) view.findViewById(R.id.icon);
		image.setImageResource(icon.img);
		TextView text = (TextView) view.findViewById(R.id.text);
		text.setText(icon.name);
		return view;
	}

	

	

}
