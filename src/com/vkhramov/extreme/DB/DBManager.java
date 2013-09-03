package com.vkhramov.extreme.DB;

import android.content.Context;
import android.util.Log;

public final class DBManager {

	Context _context;
	
	DBManager(Context context)
	{
		this._context = context;
	}
	
	public void createDB()
	{
		
        DBHelper db = new DBHelper(_context);
        
        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting .."); 
        //db.addContact(new Contact("Ravi", "9100000000"));        
        //db.addContact(new Contact("Srinivas", "9199999999"));
        //db.addContact(new Contact("Tommy", "9522222222"));
        //db.addContact(new Contact("Karthik", "9533333333"));
	}
}

