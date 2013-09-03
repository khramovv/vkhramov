package com.vkhramov.extreme.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.vkhramov.extreme.R;
import com.vkhramov.extreme.DB.DBHelper;
import com.vkhramov.extreme.DB.DBManager;
import com.vkhramov.extreme.Sport.Sport;

public class SportDetailsActivity extends Activity implements OnClickListener{

	TextView tvSportDescription;
	TextView tvSingleSportStarDescription;
	
	static final String TAG = "TAG_DETAILS";
	
	DBManager dbManager;
	//Typeface type = Typeface.createFromAsset(getAssets(),"fonts/constantia.ttf"); 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sport_details);
		
		DBHelper db = new DBHelper(this);
		
		this.createDB(db);
		
		tvSportDescription = (TextView)findViewById(R.id.tvSportDescription);
		tvSportDescription.setMovementMethod(new ScrollingMovementMethod());
		//tvSportDescription.setTypeface(type);
		tvSingleSportStarDescription = (TextView)findViewById(R.id.tvSingleSportStarDescription);
		
		String sportKind = getIntent().getExtras().getString("sportKind");
		

		
		Sport sport = db.getSport(sportKind);
		
		tvSportDescription.setText(sport.getDescription());
		tvSingleSportStarDescription.setText(R.string.skydiving_star);
		setTitle(sportKind);
		

	}

	public void createDB(DBHelper db)
	{
		
        //DBHelper db = new DBHelper(this);
        
        /**
         * CRUD Operations
         * */
        // Inserting Sports. Fill DB.
        Log.d("Insert: ", "Inserting .."); 
        String[] sportNamesEarthArray = this.getResources().getStringArray(R.array.Earth); 
        String[] sportNamesWaterArray = this.getResources().getStringArray(R.array.Water); 
        String[] sportNamesSnowArray = this.getResources().getStringArray(R.array.Snow); 
        String[] sportNamesAirArray = this.getResources().getStringArray(R.array.Air);
        String[] sportDescrEarthArray = this.getResources().getStringArray(R.array.Earth_Sports_Descriptions); 
        String[] sportDescrWaterArray = this.getResources().getStringArray(R.array.Water_Sports_Descriptions); 
        String[] sportDescrSnowArray = this.getResources().getStringArray(R.array.Snow_Sports_Descriptions); 
        String[] sportDescrAirArray = this.getResources().getStringArray(R.array.Air_Sports_Descriptions);
        
        for (int i=0; i< sportNamesEarthArray.length; i++)
        {
        	db.addSport(new Sport(sportNamesEarthArray[i], sportDescrEarthArray[i], "Earth"));
        	Log.i(TAG,db.getSport(sportNamesEarthArray[i]).getName());
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
        
        db.close();
	}
	
	@Override
	public void onClick(View v) {

	}
}
