package com.example.usmcommunitykit;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {

	static final String EXTRA_MESSAGE = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
    /** Called when the user clicks the button widget */
    public void openBrowser(View view) {
    	int id = view.getId();
		// Do something in response to button
    	
    	if(id == R.id.elearning){
    		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.elearning.usm.my/"));
        	startActivity(browserIntent);
    	}
    	else if(id == R.id.campusOnline){
        	Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.campusonline.usm.my/"));
        	startActivity(browserIntent);
        	}
    	else if(id == R.id.mail){
        	Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.outlook.com/student.usm.my"));
        	startActivity(browserIntent);
        	} 	
    }
    
    public void displayAboutUs(View view){
    	Intent intent = new Intent(this, AboutUs.class);
    	startActivity(intent);
    }
    
    public void openMap(View view){
    	Intent intent = new Intent(this, MapActivity.class);
    	startActivity(intent);
    }

}
