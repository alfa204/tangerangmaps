package com.tangerangmaps.ui;

import com.cyrilmottier.android.greendroid.R.color;
import com.tangerangmaps.R;
import com.tangerangmaps.TangerangMaps;
import com.tangerangmaps.TangerangMapsMain;
import com.tangerangmaps.object.PoiLokasi;
import com.tangerangmaps.util.ImageLoader;
import com.tangerangmaps.util.MapRoute;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import greendroid.app.GDTabActivity;
import greendroid.widget.ActionBar;
import greendroid.widget.ActionBarItem;
import greendroid.widget.NormalActionBarItem;
import greendroid.widget.ActionBarItem.Type;

public class InfoPoiDetail extends GDTabActivity{

	private static final String TAB1 = "information";
    private static final String TAB2 = "map";
    private static final String TAB3 = "comment";
	private int image;
	private String imgUrl;
	private ImageLoader imageLoader;
	ImageView picture;
	PoiLokasi poi;
	
	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
		
		poi = (PoiLokasi) getIntent().getParcelableExtra("poi");
		image = getIntent().getIntExtra("image", R.drawable.icon);
		TextView tv = new TextView(this);
		tv.setText(poi.getAlamat());
//		setTitle(poi.getNama());
		imgUrl = "http://tangerangmaps.com/images/profil/"+poi.getImageUrl();
		setContentView(R.layout.info_poi_detail);
		imageLoader = new ImageLoader(this);
		
		ActionBar bar = (ActionBar) findViewById(R.id.gd_action_bar);
		bar.setTitle(poi.getNama());
		
//		addActionBarItem(Type.Direction, R.id.action_bar_direction);
		addActionBarItem(getActionBar()
				.newActionBarItem(NormalActionBarItem.class)
				.setDrawable(com.tangerangmaps.R.drawable.ic_menu_directions)
				.setContentDescription("Direction"), R.id.action_bar_direction);
		Intent i = new Intent(this, InfoPoiDetailInformation.class);
		i.putExtra("poi", poi);
		addTab(TAB1, "Information", i);
		
		picture = (ImageView) findViewById(R.id.imgIconDetail);
		picture.setTag(imgUrl);
		imageLoader.DisplayImage(imgUrl, this, picture);
		picture.setOnClickListener(pictureClick);
		
		Intent b = new Intent(this, InfoPoiDetailMap.class);
		b.putExtra("poi", poi);
		b.putExtra("image", image);
		addTab(TAB2, "Map", b);
		
		
	}
	
	@Override
	public boolean onHandleActionBarItemClick(ActionBarItem item, int position) {
		switch (item.getItemId()) {
		case R.id.action_bar_direction:
			Intent intent = new Intent(this, MapRoute.class);
			intent.putExtra("method", "");
            intent.putExtra("latitude", poi.getLat());
            intent.putExtra("longitude", poi.getLon());
            startActivity(intent);
			break;

		default:
			break;
		}
		return true;
	}
	public View.OnClickListener pictureClick = new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			final Dialog dialog = new Dialog(v.getContext());
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);  
	        dialog.setContentView(R.layout.image_dialog);
	        ImageView imgDialog = (ImageView) dialog.findViewById(R.id.ImageViewGallery01);
	        imgDialog.setTag(imgUrl);
	        imgDialog.setScaleType(ImageView.ScaleType.FIT_XY);
	        imageLoader.DisplayImage(imgUrl, InfoPoiDetail.this, imgDialog);
	        
	        imgDialog.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					dialog.dismiss();
				}
			});
	        dialog.setTitle("");
	        dialog.setCancelable(true);
	        android.view.WindowManager.LayoutParams lp=dialog.getWindow().getAttributes();

	        lp.flags=
	        	android.view.WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS | 
	        	android.view.WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;

	        dialog.getWindow().setAttributes(lp);
	        dialog.show();
//	        stopProgress();
		}
	};
}
