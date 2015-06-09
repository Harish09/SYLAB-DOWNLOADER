package com.android.pet.view;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.doepiccoding.navigationdrawer.R;


public class About extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

                View rootView;
                rootView = inflater.inflate(R.layout.activity_about, null);

//                setContentView(R.layout.activity_about);
                Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
                        "fonts/RobotoCondensed-Bold.ttf");
                TextView tv = (TextView) rootView.findViewById(R.id.textView2);
                tv.setTypeface(tf);
                TextView tv1 = (TextView) rootView.findViewById(R.id.textView3);
                tv1.setTypeface(tf);
                TextView tv9 = (TextView) rootView.findViewById(R.id.textView10);
                tv9.setTypeface(tf);
                Typeface tf1 = Typeface.createFromAsset(getActivity().getAssets(),
                        "fonts/RobotoCondensed-Regular.ttf");
                TextView tv2 = (TextView) rootView.findViewById(R.id.textView4);
                tv2.setTypeface(tf1);
                TextView tv3 = (TextView) rootView.findViewById(R.id.textView5);
                tv3.setTypeface(tf1);
                TextView tv4 = (TextView) rootView.findViewById(R.id.textView6);
                tv4.setTypeface(tf1);
                TextView tv8 = (TextView) rootView.findViewById(R.id.textView);
                tv8.setTypeface(tf1);
                TextView tv10 = (TextView) rootView.findViewById(R.id.textView11);
                tv10.setTypeface(tf1);
                Typeface tf2 = Typeface.createFromAsset(getActivity().getAssets(),
                        "fonts/RobotoCondensed-Italic.ttf");
                TextView tv5 = (TextView) rootView.findViewById(R.id.textView7);
                tv5.setTypeface(tf2);
                TextView tv6 = (TextView) rootView.findViewById(R.id.textView8);
                tv6.setTypeface(tf2);
                TextView tv7 = (TextView) rootView.findViewById(R.id.textView9);
                tv7.setTypeface(tf2);
                TextView tv11 = (TextView) rootView.findViewById(R.id.textView12);
                tv11.setTypeface(tf2);
                TextView tv12 = (TextView) rootView.findViewById(R.id.textView13);
                tv12.setTypeface(tf2);
                ImageView img_git = (ImageView)rootView.findViewById(R.id.imageButton);
                img_git.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                                Intent intent = new Intent();
                                intent.setAction(Intent.ACTION_VIEW);
                                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                                intent.setData(Uri.parse("https://github.com/faizaanceg/SYLAB-DOWNLOADER"));
                                startActivity(intent);
                        }
                });
                ImageView img = (ImageView)rootView.findViewById(R.id.imageButton1);
                img.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                                Intent intent = new Intent();
                                intent.setAction(Intent.ACTION_VIEW);
                                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                                intent.setData(Uri.parse("https://www.facebook.com/faizaan.ceg"));
                                startActivity(intent);
                        }
                });
                ImageView img1 = (ImageView)rootView.findViewById(R.id.imageButton2);
                img1.setOnClickListener(new View.OnClickListener(){
                        public void onClick(View v){
                                Intent intent = new Intent();
                                intent.setAction(Intent.ACTION_VIEW);
                                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                                intent.setData(Uri.parse("https://www.facebook.com/harish.thecooldude"));
                                startActivity(intent);
                        }
                });
                ImageView img2 = (ImageView)rootView.findViewById(R.id.imageButton3);
                img2.setOnClickListener(new View.OnClickListener(){
                        public void onClick(View v){
                                Intent intent = new Intent();
                                intent.setAction(Intent.ACTION_VIEW);
                                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                                intent.setData(Uri.parse("https://www.facebook.com/karthick.ramjee"));
                                startActivity(intent);
                        }
                });
                ImageView img3 = (ImageView)rootView.findViewById(R.id.imageView);
                img3.setOnClickListener(new View.OnClickListener(){
                        public void onClick(View v){
                                Intent intent = new Intent();
                                intent.setAction(Intent.ACTION_VIEW);
                                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                                intent.setData(Uri.parse("https://github.com/JoanZapata/android-pdfview/blob/master/LICENSE.txt"));
                                startActivity(intent);
                        }
                });

                return rootView;
        }
}
