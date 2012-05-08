package net.agilux;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;



public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	
	private static final String TAG = "DB_STUFF";
	private static final String DATABASE_NAME = "StreetSales";
	private static final int VERSION = 1;

	public DatabaseHelper(Context context, String databaseName,
			CursorFactory factory, int databaseVersion) {
		super(context, DATABASE_NAME, factory, VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase arg0, ConnectionSource arg1) {
		// TODO Auto-generated method stub
		try {  
            Log.i(TAG, "Tables created in ");  
            TableUtils.createTable(connectionSource, Products.class);    
  
        } catch (SQLException e) {  
            Log.e(TAG, "Can't create database", e);  
            throw new RuntimeException(e);  
        } catch (java.sql.SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e(TAG, "Can't create database", e);  
            throw new RuntimeException(e);
		} 
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, ConnectionSource arg1, int arg2,
			int arg3) {
		// TODO Auto-generated method stub
		
	}

}
