package com.vkhramov.extreme.Fragments;

import com.vkhramov.extreme.R;
import com.vkhramov.extreme.Activities.SportDetailsActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
//import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.app.Fragment;
import android.content.Intent;

public class ListOfSportsFragment extends Fragment {

	
//--- List Fragment views
	// ListView
	private ListView lvSports;

	// search EditText
	private EditText inputSearch;

	private ArrayAdapter<String> adapter;

	// string array with relevant sports activities
	private String[] sports;
//---

//---Details Fragment views
	//private MultiAutoCompleteTextView mactvSportDescription;
	private TextView tvSingleSportStarDescription;
//---	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_list_of_sports, container, false);
		lvSports = (ListView)view.findViewById(R.id.lvSports);
		inputSearch = (EditText)view.findViewById(R.id.inputSearch);
		
		//lvSports.setBackgroundResource(R.drawable.back_dark_parquet_1280_800);
		
		Bundle extras = getActivity().getIntent().getExtras();
		
		switch (extras.getInt("SPORT_TYPE")) {
		case 1:
			sports = getResources().getStringArray(R.array.Earth);
			getActivity().setTitle("Sports on Earh");
			break;
		case 2:
			sports = getResources().getStringArray(R.array.Water);
			getActivity().setTitle("Water Sports");
			break;
		case 3:
			sports = getResources().getStringArray(R.array.Snow);
			getActivity().setTitle("Winter Sports");
			break;
		case 4:
			sports = getResources().getStringArray(R.array.Air);
			getActivity().setTitle("Air Sports");
			break;
		}

		adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, sports);
		lvSports.setAdapter(adapter);

		// listening to single list item on click
		lvSports.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

				// selected item
				String sportKind = ((TextView) view).getText().toString();

				startDetailsActivityIfNeeded(sportKind);
			}
		});

		inputSearch.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
				// When user changed the Text
				adapter.getFilter().filter(cs);
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		
		return view;
	}
	
	private void startDetailsActivityIfNeeded(String value)
	{
		SportDetailsFragment fragmentDetails =(SportDetailsFragment) getActivity().getFragmentManager().findFragmentById(R.id.fragmentDetails);
		if (fragmentDetails==null || !fragmentDetails.isInLayout())
		{
			Intent intent = new Intent(getActivity(), SportDetailsActivity.class);
			intent.putExtra("sportKind", value);
			startActivity(intent);
		}
		else
		{
			tvSingleSportStarDescription = (TextView)fragmentDetails.getView().findViewById(R.id.tvSingleSportStarDescription);
			tvSingleSportStarDescription.setText(value);
		}
	}
}
