package com.android.pet.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doepiccoding.navigationdrawer.R;

/**
 * Created by GOD on 5/28/2015.
 */
public class maths2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.maths2x, null);
        //TextView.class.cast(rootView.findViewById(R.id.labelText)).setText("Venus");
        Uri webPage = Uri.parse("http://cs.annauniv.edu/academic/ug2012/M2.pdf");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webPage);
        startActivity(webIntent);
        return rootView;
    }


}