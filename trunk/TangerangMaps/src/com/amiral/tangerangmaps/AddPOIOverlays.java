package com.amiral.tangerangmaps;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class AddPOIOverlays extends ItemizedOverlay {

	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	private Context mContext;
	public AddPOIOverlays(Drawable defaultMarker, Context context) {
		super(defaultMarker);
		// TODO Auto-generated constructor stub
		mContext=context;
	}

	@Override
	protected OverlayItem createItem(int i) {
		// TODO Auto-generated method stub
		return mOverlays.get(i);
	}
	
	
	public void addOverlay(OverlayItem overlay){
		mOverlays.add(overlay);
		populate();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return mOverlays.size();
	}
	
	@Override
	protected boolean onTap(int index){
		OverlayItem item = mOverlays.get(index);
		Toast.makeText(mContext,item.getSnippet(), Toast.LENGTH_SHORT);
		return true;
		
	}

}
