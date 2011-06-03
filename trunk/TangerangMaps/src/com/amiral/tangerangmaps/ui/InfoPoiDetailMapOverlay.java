package com.amiral.tangerangmaps.ui;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class InfoPoiDetailMapOverlay extends ItemizedOverlay{

	String routingMethod, sLat, sLon;
	private Context mContext;
	private Activity mActivity;
	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	
	public InfoPoiDetailMapOverlay(Drawable defaultMarker) {
		super(boundCenterBottom(defaultMarker));
		// TODO Auto-generated constructor stub
	}

	public InfoPoiDetailMapOverlay(Drawable defaultMarker, Context
			context, String lat, String lon) {
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

}
