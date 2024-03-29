package com.tangerangmaps;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;
import com.tangerangmaps.R;
import com.tangerangmaps.object.PoiLokasi;
import com.tangerangmaps.ui.InfoPoiDetail;
import com.tangerangmaps.util.MapRoute;

public class MapOverlay extends ItemizedOverlay{

	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	private Context mContext;
	private Activity mActivity;
	PoiLokasi poi;
	
	String routingMethod, sLat, sLon;
		
	public MapOverlay(Drawable defaultMarker) {
		super(boundCenterBottom(defaultMarker));
		// TODO Auto-generated constructor stub
	}

	public MapOverlay(Drawable defaultMarker, Context context,
			PoiLokasi poiSend) {
        this(defaultMarker);
        mContext = context;
        mActivity = (Activity) context;
        poi = poiSend;
        sLat = poi.getLat();
        sLon = poi.getLon();
    }	

	public MapOverlay(Drawable defaultMarker, Context context,
			String lat, String lon) {
        this(defaultMarker);
        mContext = context;
        mActivity = (Activity) context;
        sLat = lat;
        sLon = lon;
    }
	public void addOverlay(OverlayItem overlay) {
	    mOverlays.add(overlay);
	    populate();
	}
	
	@Override
	protected OverlayItem createItem(int i) {
		// TODO Auto-generated method stub
		return mOverlays.get(i);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return mOverlays.size();
	}

	@Override
	protected boolean onTap (int index) {
		 OverlayItem item = mOverlays.get(index);
		 final Dialog dialog = new Dialog(mContext);
		 final String s_branch = item.getTitle();
		 dialog.setContentView(R.layout.mapoverlay);
		 dialog.setTitle(s_branch);
		
		 LinearLayout layout = (LinearLayout) dialog.findViewById(R.id.layoutRoot);
		 ImageView image = (ImageView) dialog.findViewById(R.id.imgOverlay);
		 image.setImageResource(R.drawable.icon);
		 TextView text = (TextView) dialog.findViewById(R.id.tvText);
		 text.setText(item.getSnippet());
		 
		 if (poi!= null) {
			 layout.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Thread t = new Thread(){
							public void run(){
//								Intent intent=new Intent(mContext,MapRoute.class);
//				                intent.putExtra("method", routingMethod);
//				                intent.putExtra("latitude", sLat);
//				                intent.putExtra("longitude", sLon);
								Intent i = new Intent(mContext, InfoPoiDetail.class);
								i.putExtra("poi", poi);
				                mActivity.startActivityForResult(i, 2);
				                
				                dialog.dismiss();
							}
						};
						t.start();
					}
				});
		}
		 
		 dialog.show();
		return true;
	}
}
