package com.tangerangmaps;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class phonecalls extends Activity {
    /** Called when the activity is first created. */
	String listkey;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listkey = getIntent().getStringExtra("listphone");
        call();
	}
private void call() {
    try {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse(listkey));
        startActivity(callIntent);
    } catch (ActivityNotFoundException activityException) {
        Log.e("dialing-example", "Call failed", activityException);
    }
}

}
      