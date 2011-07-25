package com.tangerangmaps.adapter;

import java.util.List;

import com.tangerangmaps.R;
import com.tangerangmaps.object.ButtonItem;
import com.tangerangmaps.object.PageItem;
import com.tangerangmaps.ui.Education;
import com.tangerangmaps.ui.Goverment;
import com.tangerangmaps.ui.Health;
import com.tangerangmaps.ui.Living;
import com.tangerangmaps.ui.Transportation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import greendroid.widget.PagedAdapter;

public class PageViewAdapter extends PagedAdapter{

	private Context ctx;
	private List<PageItem> pageItems;
	
	public PageViewAdapter(Context ctx, List<PageItem> pageItems) {
		super();
		this.ctx = ctx;
		this.pageItems = pageItems;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return pageItems.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return pageItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		PageItem pageItem = pageItems.get(position);
		
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.categories_item, parent, false); 
        }
		
		Button btn11 = (Button) convertView.findViewById(R.id.btnR1C1);
		btn11.setCompoundDrawablesWithIntrinsicBounds(0, pageItem.getBtnR1C1().getBtnDrawable(), 0, 0);
		btn11.setText(pageItem.getBtnR1C1().getText());
		
		Button btn12 = (Button) convertView.findViewById(R.id.btnR1C2);
		btn12.setCompoundDrawablesWithIntrinsicBounds(0, pageItem.getBtnR1C2().getBtnDrawable(), 0, 0);
		btn12.setText(pageItem.getBtnR1C2().getText());
		
		Button btn21 = (Button) convertView.findViewById(R.id.btnR2C1);
		btn21.setCompoundDrawablesWithIntrinsicBounds(0, pageItem.getBtnR2C1().getBtnDrawable(), 0, 0);
		btn21.setText(pageItem.getBtnR2C1().getText());
		
		Button btn22 = (Button) convertView.findViewById(R.id.btnR2C2);
		btn22.setCompoundDrawablesWithIntrinsicBounds(0, pageItem.getBtnR2C2().getBtnDrawable(), 0, 0);
		btn22.setText(pageItem.getBtnR2C2().getText());
		
		Button btn31 = (Button) convertView.findViewById(R.id.btnR3C1);
		btn31.setCompoundDrawablesWithIntrinsicBounds(0, pageItem.getBtnR3C1().getBtnDrawable(), 0, 0);
		btn31.setText(pageItem.getBtnR3C1().getText());
		
		Button btn32 = (Button) convertView.findViewById(R.id.btnR3C2);
		btn32.setCompoundDrawablesWithIntrinsicBounds(0, pageItem.getBtnR3C2().getBtnDrawable(), 0, 0);
		btn32.setText(pageItem.getBtnR3C2().getText());
		
		return convertView;
	}
	
//	public void btnEvent(View v){
//		ButtonItem btn = (ButtonItem) v.getTag();
//		if(btn.getBtnDrawable() == R.drawable.btn_education){
//			ctx.startActivity(new Intent(ctx, Education.class));
//		}else{
//			Toast.makeText(ctx, "Bisa", Toast.LENGTH_LONG).show();
//		}
//		switch (v.getTag()) {
//		case R.id.btnGoverment:
//			ctx.startActivity(new Intent(ctx, Goverment.class));
//			break;
//		case R.id.btnEducation:
//			ctx.startActivity(new Intent(ctx, Education.class));
//			break;
//		case R.id.btnHealth:
//			ctx.startActivity(new Intent(ctx, Health.class));
//			break;
//		case R.id.btnLiving:
//			ctx.startActivity(new Intent(ctx, Living.class));
//			break;
//		case R.id.btnTransportation:
//			ctx.startActivity(new Intent(ctx, Transportation.class));
//			break;
//		default:
//			break;
//		}
//	}

}
