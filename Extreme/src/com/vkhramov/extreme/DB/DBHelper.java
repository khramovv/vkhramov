package com.vkhramov.extreme.DB;

import com.vkhramov.extreme.R;
import com.vkhramov.extreme.Sport.Sport;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

	private final String TAG = "DBHelper";
	private final static int DB_VERSION = 1;
	public final static String DB_NAME = "sportsManager"; 
	public final static String TABLE_NAME = "sports"; 
	public final static String COL_NAME = "name";
	public final static String COL_DESCR = "description";
	public final static String COL_AREA = "area";
	public final static String COL_ID = "_id";
	
	public DBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i(TAG, "onCreate");
		
		String sql = "create table "+TABLE_NAME
				+" ("+COL_ID+" integer primary key autoincrement,"
				+ COL_NAME+" text, "+ COL_DESCR+" text, "+ COL_AREA+" text)";
		db.execSQL(sql);
	}

	// Adding new sport
	public void addSport(Sport sport) {
	    SQLiteDatabase db = this.getWritableDatabase();
	 
	    ContentValues values = new ContentValues();
	    values.put(COL_NAME, sport.getName()); // sport Name
	    values.put(COL_DESCR, sport.getDescription()); // sport Description
	    values.put(COL_AREA, sport.getArea()); // sport Area
	 
	    // Inserting Row
	    db.insert(TABLE_NAME, null, values);
	    db.close(); // Closing database connection
	}
	
	// Getting sport
	public Sport getSport(String sportName)
	{
		SQLiteDatabase db = this.getReadableDatabase();
		//select * from TABLE_NAME
		
		String[] columns = new String[]{DBHelper.COL_NAME, DBHelper.COL_DESCR, DBHelper.COL_AREA };
		String selection = DBHelper.COL_NAME+"=?";
		String[] argSelection = new String []{sportName};
		Cursor cursor = db.query(DBHelper.TABLE_NAME, columns, selection, argSelection, null, null, null);
		
		Sport sport = new Sport(cursor.getString(0), cursor.getString(1), cursor.getString(2));
		
	    db.close(); // Closing database connection
	    
		return sport;
	}
	

	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
}
