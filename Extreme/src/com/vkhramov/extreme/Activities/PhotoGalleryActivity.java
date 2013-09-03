package com.vkhramov.extreme.Activities;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.vkhramov.extreme.R;

public class PhotoGalleryActivity extends Activity {

	private Bitmap[] GalImages;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photo_gallery);

		GalImages = new Bitmap[] { getBitmapFromAsset("Air/air1.jpg"),
				getBitmapFromAsset("Air/air2.jpg"),
				getBitmapFromAsset("Air/air3.jpg") };

		ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
		ImageAdapter adapter = new ImageAdapter(this, GalImages);
		viewPager.setAdapter(adapter);
	}

	private Bitmap getBitmapFromAsset(String strName) {
		AssetManager assetManager = this.getAssets();
		InputStream istr = null;
		try {
			istr = assetManager.open(strName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Bitmap bitmap = BitmapFactory.decodeStream(istr);
		return bitmap;
	}
}
