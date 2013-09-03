package com.vkhramov.extreme.Activities;

import java.io.IOException;
import java.io.InputStream;

import com.vkhramov.extreme.R;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageAdapter extends PagerAdapter {
	Context context;
	Bitmap[] GalImages;
	
//    private Bitmap[] GalImages = new Bitmap[] {
//        getBitmapFromAsset("Air/air1.jpg"),
//        getBitmapFromAsset("Air/air2.jpg"),
//        getBitmapFromAsset("Air/air3.jpg")
//    };
	
//private int[] GalImages = new int[] {
//R.drawable.air1,
//R.drawable.air2,
//R.drawable.air3
//};
    ImageAdapter(Context context, Bitmap[] bitGal){
    	this.context=context;
    	this.GalImages = bitGal;
    }
    @Override
    public int getCount() {
      return GalImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
      return view == ((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
      ImageView imageView = new ImageView(context);
      int padding = context.getResources().getDimensionPixelSize(R.dimen.padding_medium);
      imageView.setPadding(padding, padding, padding, padding);
      imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      imageView.setImageBitmap(GalImages[position]);
      //imageView.setImageResource(GalImages[position]);
      ((ViewPager) container).addView(imageView, 0);
      return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
      ((ViewPager) container).removeView((ImageView) object);
    }
    
//    private Bitmap getBitmapFromAsset(String strName)
//    {
//        AssetManager assetManager = context.getAssets();
//        InputStream istr = null;
//        try {
//            istr = assetManager.open(strName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Bitmap bitmap = BitmapFactory.decodeStream(istr);
//        return bitmap;
//    }
  }
