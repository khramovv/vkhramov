package com.vkhramov.extreme.Activities;

import com.vkhramov.extreme.*;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity implements OnClickListener, OnTouchListener{

	ImageButton ibtnEarth;
	ImageButton ibtnWater;
	ImageButton ibtnSnow;
	ImageButton ibtnAir;
	Button btnPhoto;
	Button btnVideo;
	
	ObjectAnimator anim_up;
	ObjectAnimator anim_down;
	
	private final int EARTH_CONST = 1;
	private final int WATER_CONST = 2;
	private final int SNOW_CONST = 3;
	private final int AIR_CONST = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ibtnEarth = (ImageButton) findViewById(R.id.ibtnEarth);
		ibtnWater = (ImageButton) findViewById(R.id.ibtnWater);
		ibtnSnow = (ImageButton) findViewById(R.id.ibtnSnow);
		ibtnAir = (ImageButton) findViewById(R.id.ibtnAir);
		btnPhoto = (Button) findViewById(R.id.btnPhotoG);
		btnVideo = (Button) findViewById(R.id.btnVideoG);
		btnPhoto.setOnTouchListener(this);
		btnVideo.setOnTouchListener(this);
		
		ibtnEarth.setOnClickListener(this);
		ibtnWater.setOnClickListener(this);
		ibtnSnow.setOnClickListener(this);
		ibtnAir.setOnClickListener(this);
		ibtnSnow.setOnClickListener(this);
		ibtnAir.setOnClickListener(this);
		btnPhoto.setOnClickListener(this);
		btnVideo.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.ibtnEarth:
			intent = new Intent(this, ListOfSportsActivity.class);
			intent.putExtra("SPORT_TYPE", EARTH_CONST);
			break;

		case R.id.ibtnWater:
			intent = new Intent(this, ListOfSportsActivity.class);
			intent.putExtra("SPORT_TYPE", WATER_CONST);
			break;

		case R.id.ibtnSnow:
			intent = new Intent(this, ListOfSportsActivity.class);
			intent.putExtra("SPORT_TYPE", SNOW_CONST);
			break;

		case R.id.ibtnAir:
			intent = new Intent(this, ListOfSportsActivity.class);
			intent.putExtra("SPORT_TYPE", AIR_CONST);
			break;
		
		case R.id.btnPhotoG:
			intent = new Intent(this, PhotoGalleryActivity.class);
			break;

		case R.id.btnVideoG:
			intent = new Intent(this, PhotoGalleryActivity.class);
			break;
			
		default: intent = new Intent();
			break;
		}
		startActivity(intent);

	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		switch(event.getAction())
		{
		case MotionEvent.ACTION_DOWN:
			switch (v.getId())
			{
			case R.id.btnPhotoG:
				//btnPhoto.setBackgroundDrawable((getResources().getDrawable(R.drawable.gradient_light)));
				break;
			case R.id.btnVideoG:
				//btnVideo.setBackgroundDrawable((getResources().getDrawable(R.drawable.gradient_light)));
				break;
			}
			//v.animate().x(v.getX()+4).y(v.getY()+4);
			break;
			
		case MotionEvent.ACTION_UP:
			switch (v.getId())
			{
			case R.id.btnPhotoG:
				//btnPhoto.setBackgroundDrawable((getResources().getDrawable(R.drawable.gradient_dark)));
				break;
			case R.id.btnVideoG:
				//btnVideo.setBackgroundDrawable((getResources().getDrawable(R.drawable.gradient_dark)));
				break;
			}
			//v.animate().x(v.getX()-4).y(v.getY()-4);
			break;
		}
		return false;
	}

}