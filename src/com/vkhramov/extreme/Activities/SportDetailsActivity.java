package com.vkhramov.extreme.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.vkhramov.extreme.R;

public class SportDetailsActivity extends Activity implements OnClickListener{

	TextView tvSportDescription;
	TextView tvSingleSportStarDescription;
	//Typeface type = Typeface.createFromAsset(getAssets(),"fonts/constantia.ttf"); 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sport_details);
		
		tvSportDescription = (TextView)findViewById(R.id.tvSportDescription);
		tvSportDescription.setMovementMethod(new ScrollingMovementMethod());
		//tvSportDescription.setTypeface(type);
		tvSingleSportStarDescription = (TextView)findViewById(R.id.tvSingleSportStarDescription);
		
		String sportKind = getIntent().getExtras().getString("sportKind");
		tvSportDescription.setText(R.string.skydiving_description);
		tvSingleSportStarDescription.setText(R.string.skydiving_star);
		setTitle(sportKind);
		
	}

	@Override
	public void onClick(View v) {

	}
}
