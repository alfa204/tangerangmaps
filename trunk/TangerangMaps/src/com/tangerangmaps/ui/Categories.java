package com.tangerangmaps.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import greendroid.app.GDActivity;
import greendroid.widget.PageIndicator;
import greendroid.widget.PagedAdapter;
import greendroid.widget.PagedView;
import greendroid.widget.ActionBarItem.Type;
import greendroid.widget.PagedView.OnPagedViewChangeListener;

import com.tangerangmaps.R;
import com.tangerangmaps.adapter.PageViewAdapter;
import com.tangerangmaps.object.ButtonItem;
import com.tangerangmaps.object.PageItem;
import com.tangerangmaps.webservice.GetAllPOI;

public class Categories extends GDActivity{
	private static int PAGE_MAX_INDEX = 0;
//	private static final int PAGE_COUNT = 3;
//    private static final int PAGE_MAX_INDEX = PAGE_COUNT - 1;

    private PageIndicator mPageIndicatorNext;
    private PageIndicator mPageIndicatorPrev;
//    private PageIndicator mPageIndicatorOther;
    Context ctx;
    
    List<PageItem> pageItems;
    
    
    @Override
    protected void onCreate(Bundle bundle){
    	super.onCreate(bundle);
    	setActionBarContentView(R.layout.categories_page);
    	setTitle("Categories");
    	addActionBarItem(Type.LocateMyself, R.id.action_bar_nearby);
		addActionBarItem(Type.Search,R.id.action_bar_search);
		ctx = this;
		new PoiSync().execute();
		
    	pageItems = new ArrayList<PageItem>();
    	
    	ButtonItem btn11 = new ButtonItem(R.string.street, R.drawable.btn_street);
    	ButtonItem btn12 = new ButtonItem(R.string.gov,R.drawable.btn_goverment);
    	ButtonItem btn21 = new ButtonItem(R.string.edu, R.drawable.btn_education);
    	ButtonItem btn22 = new ButtonItem(R.string.health, R.drawable.btn_health);
    	ButtonItem btn31 = new ButtonItem(R.string.living, R.drawable.btn_living);
    	ButtonItem btn32 = new ButtonItem(R.string.transportasi, R.drawable.btn_transportation);
    	PageItem item = new PageItem(btn11, btn12, btn21, btn22, btn31, btn32);
    	
    	ButtonItem btn111 = new ButtonItem(R.string.bank, R.drawable.btn_bank);
    	ButtonItem btn112 = new ButtonItem(R.string.shopping, R.drawable.btn_shopping);
    	ButtonItem btn121 = new ButtonItem(R.string.culinary, R.drawable.btn_culinary);
    	ButtonItem btn122 = new ButtonItem(R.string.sport, R.drawable.btn_sport);
    	ButtonItem btn131 = new ButtonItem(R.string.travel, R.drawable.btn_travel);
    	ButtonItem btn132 = new ButtonItem(R.string.entertaiment, R.drawable.btn_entertaiment);
    	PageItem item2 = new PageItem(btn111, btn112, btn121, btn122, btn131, btn132);
    	
    	ButtonItem btn211 = new ButtonItem(R.string.service, R.drawable.btn_service);
    	ButtonItem btn212 = new ButtonItem(R.string.facility, R.drawable.btn_facility);
    	ButtonItem btn221 = new ButtonItem(R.string.culinary, R.drawable.btn_culinary);
    	ButtonItem btn222 = new ButtonItem(R.string.sport, R.drawable.btn_sport);
    	ButtonItem btn231 = new ButtonItem(R.string.travel, R.drawable.btn_travel);
    	ButtonItem btn232 = new ButtonItem(R.string.entertaiment, R.drawable.btn_entertaiment);
//    	PageItem item3 = new PageItem();
//    	item3.setBtnR1C1(btn211);
//    	item3.setBtnR1C2(btn212);
    	
    	pageItems.add(item);
    	pageItems.add(item2);
//    	pageItems.add(item3);
    	
    	PageViewAdapter adapter = new PageViewAdapter(this, pageItems);
    	
    	final PagedView pagedView = (PagedView) findViewById(R.id.paged_view);
    	pagedView.setOnPageChangeListener(mOnPagedViewChangedListener);
//    	pagedView.setAdapter(new PhotoSwipeAdapter());
    	pagedView.setAdapter(adapter);
    	
    	int PAGE_COUNT = pageItems.size();
    	PAGE_MAX_INDEX = PAGE_COUNT - 1;
    	
    	mPageIndicatorNext = (PageIndicator) findViewById(R.id.page_indicator_next);
        mPageIndicatorNext.setDotCount(PAGE_MAX_INDEX);
        mPageIndicatorNext.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                pagedView.smoothScrollToNext();
            }
        });
        
        mPageIndicatorPrev = (PageIndicator) findViewById(R.id.page_indicator_prev);
        mPageIndicatorPrev.setDotCount(PAGE_MAX_INDEX);
        mPageIndicatorPrev.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                pagedView.smoothScrollToPrevious();
            }
        });
        
        
        
//        mPageIndicatorOther = (PageIndicator) findViewById(R.id.page_indicator_other);
//        mPageIndicatorOther.setDotCount(PAGE_COUNT);
        
        setActivePage(pagedView.getCurrentPage());
    }
    
    private void setActivePage(int page) {
//        mPageIndicatorOther.setActiveDot(page);
        mPageIndicatorNext.setActiveDot(PAGE_MAX_INDEX - page);
        mPageIndicatorPrev.setActiveDot(page);
    }
    
    private OnPagedViewChangeListener mOnPagedViewChangedListener = new OnPagedViewChangeListener() {

        @Override
        public void onStopTracking(PagedView pagedView) {
        }

        @Override
        public void onStartTracking(PagedView pagedView) {
        }

        @Override
        public void onPageChanged(PagedView pagedView, int previousPage, int newPage) {
            setActivePage(newPage);
        }
    };

    public void btnEvent(View v){
    	Button btn = (Button) v;
    	String a= btn.getText().toString();
    	if(a.equals(getString(R.string.gov))){
    		startActivity(new Intent(this, Goverment.class));
    	}else if (a.equals(getString(R.string.edu))) {
    		startActivity(new Intent(this, Education.class));
		}else if (a.equals(getString(R.string.health))) {
    		startActivity(new Intent(this, Health.class));
		}else if (a.equals(getString(R.string.living))) {
    		startActivity(new Intent(this, Living.class));
		}else if (a.equals(getString(R.string.transportasi))) {
    		startActivity(new Intent(this, Transportation.class));
		}else{
			Toast.makeText(this, "Bisa: "+a, Toast.LENGTH_LONG).show();
		}
	}
   /*
    private class PhotoSwipeAdapter extends PagedAdapter {
        
        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.categories_item, parent, false);
            }
            Button btnR1C1 = (Button) convertView.findViewById(R.id.btnR1C1);
//            ((TextView) convertView).setText(Integer.toString(position));

            return convertView;
        }

    }
    
    */
    
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



