package com.khf.inferno.sylab;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.doepiccoding.navigationdrawer.R;

import java.util.ArrayList;


public class About extends Fragment {

    private TextView pdfLicense;
    private AlertDialog dialog;

    public void makeList(ListView lV) {
        final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Section");
        arrayList.add("Item");
        arrayList.add("Section");
        arrayList.add("Item");
        arrayList.add("Item");
        arrayList.add("Item");
        arrayList.add("Section");
        arrayList.add("Item");
        final MyAdapter arrayAdapter = new MyAdapter(getActivity().getApplicationContext(), arrayList);
        lV.setAdapter(arrayAdapter);
    }

    public void setupAlert() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity().getApplicationContext(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
        alertDialogBuilder.setCancelable(true);
        alertDialogBuilder.setView(pdfLicense);
        dialog = alertDialogBuilder.create();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pdfLicense = new TextView(getActivity().getApplicationContext());
        pdfLicense.setText("Copyright 2013-2015 Joan Zapata\n" +
                "\n" +
                "This file is part of Android-pdfview.\n" +
                "\n" +
                "Android-pdfview is free software: you can redistribute it and/or modify\n" +
                "it under the terms of the GNU General Public License as published by\n" +
                "the Free Software Foundation, either version 3 of the License, or\n" +
                "(at your option) any later version.\n" +
                "\n" +
                "Android-pdfview is distributed in the hope that it will be useful,\n" +
                "but WITHOUT ANY WARRANTY; without even the implied warranty of\n" +
                "MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\n" +
                "GNU General Public License for more details.\n");
       // setupAlert();
      //  makeList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView;
        rootView = inflater.inflate(R.layout.about, null);

        ListView listView = (ListView) rootView.findViewById(R.id.aboutView);
        makeList(listView);

        return rootView;

    /*
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
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity().getApplicationContext(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
                    alertDialogBuilder.setCancelable(true);
                    alertDialogBuilder.setView(pdfLicense);
                    dialog = alertDialogBuilder.create();
                    dialog.setContentView(pdfLicense, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                }
        });

        //
        //
        return rootView;*/

    }
}

class MyAdapter extends ArrayAdapter<String> {

    private Context context;
    private ArrayList<String> values;
    private Typeface italic;
    private Typeface bold;

    //private String[] name = {"Mohammed Faizaan", "Harish Murali", "Karthick Ramjee"};
    private String[] headings = {"About Us", "Source Code", "Developer Profile", "Mohammed Faizaan", "Harish Murali", "Karthick Ramjee", "Open Source Licenses", "Android-pdfView"};
    private String[] alias = {"PAD", "v1.0.2", "PAD", "Aulisius F.", "Ranguski", "Mac", "PAD", "License"};
    private int[] images = {R.drawable.fb, R.drawable.github};

    MyAdapter(Context context, ArrayList<String> values) {
        super(context, R.layout.list_about, values);
        this.context = context;
        this.values = values;
        italic = Typeface.createFromAsset(context.getAssets(),"fonts/RobotoCondensed-Italic.ttf");
        bold = Typeface.createFromAsset(context.getAssets(), "fonts/RobotoCondensed-Bold.ttf");

    }

    @Override
    public View getView(int position, View v, ViewGroup root) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        if(position == 0 || position == 2 || position == 6)
        {
            View rowView = inflater.inflate(R.layout.list_about_section, root, false);

            TextView textName = (TextView) rowView.findViewById(R.id.name);
            textName.setText(headings[position]);
            textName.setTypeface(bold);
            textName.setFocusable(false);
            textName.setClickable(false);

            return rowView;
        }

        View rowView = inflater.inflate(R.layout.list_about, root, false);

        TextView textName = (TextView) rowView.findViewById(R.id.name);
        textName.setText(headings[position]);
        textName.setTypeface(bold);

        TextView textAlias = (TextView) rowView.findViewById(R.id.alias);
        textAlias.setText(alias[position]);
        textAlias.setTypeface(italic);

        ImageView iV = (ImageView) rowView.findViewById(R.id.photo);
        iV.setImageResource(position == 1 || position == 7 ? images[1] : images[0]);

        return rowView;

    }
}
