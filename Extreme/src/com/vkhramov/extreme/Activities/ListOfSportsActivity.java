package com.vkhramov.extreme.Activities;

import com.vkhramov.extreme.R;

import android.os.Bundle;
import android.app.Activity;


public class ListOfSportsActivity extends Activity {
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_of_sports);
	}
	

	
/*		// ListView
		private ListView lvSports;

		// search EditText
		private EditText inputSearch;

		private ArrayAdapter<String> adapter;

		// string array with relevant sports activities
		private String[] sports;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_list_of_sports);

			Bundle extras = getIntent().getExtras();
			lvSports = (ListView) findViewById(R.id.lvSports);
			inputSearch = (EditText) findViewById(R.id.inputSearch);

			lvSports.setBackgroundResource(R.drawable.back_dark_parquet_1280_800);
			
			
			switch (extras.getInt("SPORT_TYPE")) {
			case 1:
				sports = getResources().getStringArray(R.array.Earth);
				setTitle("Sports on Earh");
				break;
			case 2:
				sports = getResources().getStringArray(R.array.Water);
				setTitle("Water Sports");
				break;
			case 3:
				sports = getResources().getStringArray(R.array.Snow);
				setTitle("Winter Sports");
				break;
			case 4:
				sports = getResources().getStringArray(R.array.Air);
				setTitle("Air Sports");
				break;
			}

			adapter = new ArrayAdapter<String>(this, R.layout.list_item,
					R.id.tvListItem, sports);
			lvSports.setAdapter(adapter);

			// listening to single list item on click
			lvSports.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {

					// selected item
					String sportKind = ((TextView) view).getText().toString();

					// Launching new Activity on selecting single List Item
					Intent i = new Intent(getApplicationContext(),
							SportDetailsActivity.class);
					// sending data to new activity
					i.putExtra("sportKind", sportKind);
					startActivity(i);
				}
			});

			inputSearch.addTextChangedListener(new TextWatcher() {

				@Override
				public void onTextChanged(CharSequence cs, int arg1, int arg2,
						int arg3) {
					// When user changed the Text
					adapter.getFilter().filter(cs);
				}

				@Override
				public void beforeTextChanged(CharSequence arg0, int arg1,
						int arg2, int arg3) {
					// TODO Auto-generated method stub

				}

				@Override
				public void afterTextChanged(Editable s) {
					// TODO Auto-generated method stub
					
				}
			});
		}
*/
	}
