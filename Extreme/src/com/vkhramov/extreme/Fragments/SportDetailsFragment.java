package com.vkhramov.extreme.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vkhramov.extreme.R;

public class SportDetailsFragment extends Fragment{

	TextView tvSportDescription;
	TextView tvSingleSportStarDescription;
	//Typeface type = Typeface.createFromAsset(getActivity().getAssets(),"fonts/constantia.ttf"); 
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_sport_details,  container, false);
		
		tvSportDescription = (TextView)view.findViewById(R.id.tvSportDescription);
		tvSportDescription.setMovementMethod(new ScrollingMovementMethod());
		tvSingleSportStarDescription = (TextView)view.findViewById(R.id.tvSingleSportStarDescription);
		//tvSportDescription.setTypeface(type);
		
		String sportKind = getActivity().getIntent().getExtras().getString("sportKind");
		tvSportDescription.setText(R.string.skydiving_description);
		tvSingleSportStarDescription.setText(R.string.skydiving_star);
		getActivity().setTitle(sportKind);
		
		return view;
	}
}
