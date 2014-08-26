package com.example.usmcommunitykit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class AboutUs extends ActionBarActivity {

	private WebView myWebView;
	
	@SuppressLint({ "SetJavaScriptEnabled", "JavascriptInterface" })
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_us);
		
			myWebView = (WebView)findViewById(R.id.webview);
         
	        //enable Javascript
	        myWebView.getSettings().setJavaScriptEnabled(true);
	         
	        //loads the WebView completely zoomed out
	        myWebView.getSettings().setLoadWithOverviewMode(true);
	         
	        //true makes the Webview have a normal viewport such as a normal desktop browser 
	        //when false the webview will have a viewport constrained to it's own dimensions
	        myWebView.getSettings().setUseWideViewPort(true);
	                 
	        //Injects the supplied Java object into this WebView. The object is injected into the 
	        //JavaScript context of the main frame, using the supplied name. This allows the 
	        //Java object's public methods to be accessed from JavaScript.
	        myWebView.addJavascriptInterface(new WebAppInterface(this), "Android"); 
	        //load the about page page URL
	        myWebView.loadUrl("file:///android_asset/AboutUs.html");

	}
	
	
    public void callSendfeebackIntent() {
    	Intent intent = new Intent(this, SendFeeback.class);
    	startActivity(intent);	
    }
    
    
	public class WebAppInterface {
        Context mContext;

        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

        @JavascriptInterface
        public void sendFeeback() {
        	callSendfeebackIntent();
        }
        
    }	
	  

	 //Web view has record of all pages visited so you can go back and forth
	 //just override the back button to go back in history if there is page
	 //available for display
	 @Override
	 public boolean onKeyDown(int keyCode, KeyEvent event) {
	     if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
	         myWebView.goBack();
	         return true;
	     }
	     return super.onKeyDown(keyCode, event);
	 }
	 
		@Override
		protected void onRestoreInstanceState(Bundle savedInstanceState)
		{
		super.onSaveInstanceState(savedInstanceState);
		myWebView.restoreState(savedInstanceState);
		myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
		}
		
	}
