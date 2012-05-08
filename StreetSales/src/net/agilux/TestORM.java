package net.agilux;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

public class TestORM extends OrmLiteBaseActivity{
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    	ListView listView = (ListView) findViewById(R.id.listView1);
    	/*String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
    		"Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
    		"Linux", "OS/2" };*/
    	

    	// First paramenter - Context
    	// Second parameter - Layout for the row
    	// Third parameter - ID of the View to which the data is written
    	// Forth - the Array of data
    	ArrayAdapter<Products> adapter = new ArrayAdapter<Products>(this,
    		R.layout.main1, R.id.textView1,getListCategoryFromDb() );

    	// Assign adapter to ListView
    	listView.setAdapter(adapter);
    }
    
    public List<Products> getListCategoryFromDb() {  
        List<Products> categoryListFromCache =null; 
        OrmLiteSqliteOpenHelper helper = getHelper();
        DatabaseHelper absHelper = (DatabaseHelper) helper;  
         
        
        try {  
        	Dao< Products, String> dao = (Dao< Products, String>) absHelper  
                    .getDao(Products.class);
      
            //QueryBuilder<Products, String> queryBuilder = dao.queryBuilder();  
      
           // @SuppressWarnings("rawtypes")  
            //Where where = queryBuilder.where();  
            //where.eq(Category.COLUMN_SUB_CAT, "1"); // Categorie de niveau 1  
      
            //PreparedQuery<category> preparedQuery = queryBuilder.prepare();  
        	categoryListFromCache = dao.queryForAll();  
            //setList(categoryListFromCache);  
        } catch (Exception e) {  
            // TODO: handle exception  
        } 
        return categoryListFromCache;  
    }

}
