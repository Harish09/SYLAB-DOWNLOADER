package com.khf.inferno.sylab;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.doepiccoding.navigationdrawer.R;

import java.util.ArrayList;


public class About extends Fragment {

    //private TextView pdfLicense;
    //private AlertDialog dialog;
    private Intent intent;

    public void makeList(ListView lV) {
        Point p = new Point();
        WindowManager windowManager = getActivity().getWindowManager();
        Display dP = windowManager.getDefaultDisplay();
        dP.getSize(p);
        final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(Integer.toString(p.x));
        arrayList.add("Section");
        arrayList.add("Item");
        arrayList.add("Item");
        arrayList.add("Item");
        arrayList.add("Section");
        arrayList.add("Item");
        intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        final MyAdapter arrayAdapter = new MyAdapter(getActivity().getApplicationContext(), arrayList);
        lV.setAdapter(arrayAdapter);
        lV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        intent.setData(Uri.parse("https://github.com/faizaanceg/SYLAB-DOWNLOADER"));
                        break;
                    case 2:
                        intent.setData(Uri.parse("https://www.facebook.com/faizaan.ceg"));
                        break;
                    case 3:
                        intent.setData(Uri.parse("https://www.facebook.com/harish.thecooldude"));
                        break;
                    case 4:
                        intent.setData(Uri.parse("https://www.facebook.com/karthick.ramjee"));
                        break;
                    case 6:
                        intent.setData(Uri.parse("https://github.com/JoanZapata/android-pdfview/blob/master/LICENSE.txt"));
                        break;
                    default:
                        return;
                }
                startActivity(intent);
            }
        });
    }

    /*public void setupAlert() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity().getApplicationContext(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
        alertDialogBuilder.setCancelable(true);
        alertDialogBuilder.setView(pdfLicense);
        dialog = alertDialogBuilder.create();
    }*/

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* = new TextView(getActivity().getApplicationContext());
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
       */
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.about, null);

        ListView listView = (ListView) rootView.findViewById(R.id.aboutView);
        makeList(listView);

        return rootView;

    }
}

class MyAdapter extends ArrayAdapter<String> {

    private Context context;
    private ArrayList<String> values;
    private Typeface italic;
    private Typeface bold;
    private Typeface normal;

    private int[] headings = {R.string.code, R.string.developer, R.string.aulisius, R.string.ranguski, R.string.mac, R.string.license, R.string.pdfView};
    private int[] alias = {R.string.version, -1, R.string.alias_faizaan, R.string.alias_harish, R.string.alias_karthi, -1, R.string.license};
    private int[] images = {R.drawable.fb, R.drawable.github};

    MyAdapter(Context context, ArrayList<String> values) {
        super(context, R.layout.list_about, values);
        this.context = context;
        this.values = values;
        italic = Typeface.createFromAsset(context.getAssets(),"fonts/RobotoCondensed-Italic.ttf");
        bold = Typeface.createFromAsset(context.getAssets(), "fonts/RobotoCondensed-Bold.ttf");
        normal = Typeface.createFromAsset(context.getAssets(), "fonts/RobotoCondensed-Regular.ttf");
    }

    @Override
    public View getView(int position, View v, ViewGroup root) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        if(position == 1 || position == 5){

            View rowView = inflater.inflate(R.layout.list_about_section, root, false);

            TextView textName = (TextView) rowView.findViewById(R.id.name);
            textName.setText(headings[position]);
            textName.setTypeface(bold);
            textName.setFocusable(false);
            textName.setClickable(false);

            Rect bounds = new Rect();
            textName.getPaint().getTextBounds(textName.getText().toString(), 0, textName.getText().length(), bounds);
            int  textWidth = bounds.width();
            int widthScreen = Integer.parseInt(values.get(0));
            int paddingLR = widthScreen - textWidth;

            textName.setPadding(paddingLR/2, 5, 0, 5);

            return rowView;
        }

        View rowView = inflater.inflate(R.layout.list_about, root, false);

        TextView textName = (TextView) rowView.findViewById(R.id.name);
        textName.setText(headings[position]);
        textName.setTypeface(normal);

        TextView textAlias = (TextView) rowView.findViewById(R.id.alias);
        textAlias.setText(alias[position]);
        textAlias.setTypeface(italic);

        ImageView iV = (ImageView) rowView.findViewById(R.id.photo);
        iV.setImageResource(position == 0 || position == 6 ? images[1] : images[0]);

        return rowView;

    }
}
