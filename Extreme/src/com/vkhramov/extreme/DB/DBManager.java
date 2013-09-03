package com.vkhramov.extreme.DB;

import com.vkhramov.extreme.R;
import com.vkhramov.extreme.Sport.Sport;

import android.content.Context;
import android.util.Log;

public final class DBManager {

	Context _context;
	
	public DBManager(Context context)
	{
		this._context = context;
	}
	
	public void createDB()
	{
		
        DBHelper db = new DBHelper(_context);
        
        /**
         * CRUD Operations
         * */
        // Inserting Sports. Fill DB.
        Log.d("Insert: ", "Inserting .."); 
        String[] sportNamesEarthArray = _context.getResources().getStringArray(R.array.Earth); 
        String[] sportNamesWaterArray = _context.getResources().getStringArray(R.array.Water); 
        String[] sportNamesSnowArray = _context.getResources().getStringArray(R.array.Snow); 
        String[] sportNamesAirArray = _context.getResources().getStringArray(R.array.Air);
        String[] sportDescrEarthArray = _context.getResources().getStringArray(R.array.Earth_Sports_Descriptions); 
        String[] sportDescrWaterArray = _context.getResources().getStringArray(R.array.Water_Sports_Descriptions); 
        String[] sportDescrSnowArray = _context.getResources().getStringArray(R.array.Snow_Sports_Descriptions); 
        String[] sportDescrAirArray = _context.getResources().getStringArray(R.array.Air_Sports_Descriptions);
        
        for (int i=0; i< sportNamesEarthArray.length; i++)
        {
        	db.addSport(new Sport(sportNamesEarthArray[i], sportDescrEarthArray[i], "Earth"));
        }
        for (int i=0; i< sportNamesWaterArray.length; i++)
        {
        	db.addSport(new Sport(sportNamesWaterArray[i], sportDescrWaterArray[i], "Water"));
        }
        for (int i=0; i< sportNamesSnowArray.length; i++)
        {
        	db.addSport(new Sport(sportNamesSnowArray[i], sportDescrSnowArray[i], "Snow"));
        }
        for (int i=0; i< sportNamesAirArray.length; i++)
        {
        	db.addSport(new Sport(sportNamesAirArray[i], sportDescrAirArray[i], "Air"));
        }
	}
}

