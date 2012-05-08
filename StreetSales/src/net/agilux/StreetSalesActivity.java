package net.agilux;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class StreetSalesActivity extends Activity {
    /** Called when the activity is first created. */
	private static final String fields[] = { "first", "last" , BaseColumns._ID};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    	ListView listView = (ListView) findViewById(R.id.listView1);
    	String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
    		"Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
    		"Linux", "OS/2" };

    	// First paramenter - Context
    	// Second parameter - Layout for the row
    	// Third parameter - ID of the View to which the data is written
    	// Forth - the Array of data
    	//ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
    		//R.layout.main1, R.id.textView1, values);
    	
    	
    	
    	DatabaseHelperNormal helper = new DatabaseHelperNormal(this);
    	SQLiteDatabase database = helper.getWritableDatabase();
    	Cursor data = database.query("names", fields,null, null, null, null, null);
    	
    	SimpleCursorAdapter dataSource = new SimpleCursorAdapter(this,
    			            R.layout.main1, data, fields,
    			            new int[] { R.id.textView3,  R.id.textView2 });

    	
    	

    	// Assign adapter to ListView
    	listView.setAdapter(dataSource);
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
    	// Inflate the menu XML resource.
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.menu, menu);
    	return true;
    }
    
    
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.add:
			Toast.makeText(this, "Jump up in the air!", Toast.LENGTH_LONG)
					.show();
			return true;
		case R.id.delete:
			Toast.makeText(this, "Dive into the water!", Toast.LENGTH_LONG)
					.show();
			return true;
		}
		return false;
	}
	
	 @Override
	 public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
	   super.onCreateContextMenu(menu, v, menuInfo);
	   //menu.setHeaderIcon(R.drawable.icon);
	   menu.setHeaderTitle("Share Menu.");
	  // MenuInflater inflater = getMenuInflater();

	  // inflater.inflate(R.menu.menu, menu);
	   menu.add(0, Menu.FIRST , Menu.NONE, "menu #1");
	   menu.add(0, Menu.FIRST + 1, Menu.NONE, "menu #2");
	   menu.add(0, Menu.FIRST + 2, Menu.NONE, "menu #3");
	   menu.add(0, Menu.FIRST + 3, Menu.NONE, "menu #4");
	   
	 } 
}