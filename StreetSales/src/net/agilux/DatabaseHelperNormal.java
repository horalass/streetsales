package net.agilux;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DatabaseHelperNormal extends SQLiteOpenHelper {

	public DatabaseHelperNormal(Context context) {
		super(context, "CursorDemo1", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS names ("
				+  BaseColumns._ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, first VARCHAR, last VARCHAR)");
		db.execSQL("INSERT INTO names (first, last) VALUES ('John', 'Doe')");
		db.execSQL("INSERT INTO names (first, last) VALUES ('James', 'Kirk')");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Steps to upgrade the database for the new version ...
	}


}
