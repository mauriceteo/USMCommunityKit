package com.example.usmcommunitykit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

@SuppressLint("JavascriptInterface")
public class MapActivity extends ActionBarActivity {
	WebView webview ;
	
		@SuppressLint({ "SetJavaScriptEnabled", "NewApi" })
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);

			setContentView(R.layout.activity_map);
			webview = (WebView) findViewById(R.id.mapview);
			webview.setWebChromeClient(new WebChromeClient());
			WebSettings webSettings = webview.getSettings();
			webview.getSettings().setSupportZoom(true);
			webview.getSettings().setBuiltInZoomControls(true);
			webview.getSettings().setUseWideViewPort(true);
			webview.addJavascriptInterface(new WebAppInterface(this), "Android");
			webSettings.setJavaScriptEnabled(true);
			webview.loadUrl("file:///android_asset/map.html");	
			}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
	
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.map, menu);
			return true;
		}
	
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// Handle action bar item clicks here. The action bar will
			// automatically handle clicks on the Home/Up button, so long
			// as you specify a parent activity in AndroidManifest.xml.
			int id = item.getItemId();
			if (id == R.id.action_settings) {
				return true;
			}
			return super.onOptionsItemSelected(item);
		}
		
		public class WebAppInterface {
	        Context mContext;
	
	        /** Instantiate the interface and set the context */
	        WebAppInterface(Context c) {
	            mContext = c;
        }
        
    }	
}
