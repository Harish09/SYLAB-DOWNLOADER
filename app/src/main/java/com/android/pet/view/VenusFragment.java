package com.android.pet.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doepiccoding.navigationdrawer.R;

public class VenusFragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		//TextView.class.cast(rootView.findViewById(R.id.labelText)).setText("Venus");
	//	Uri webPage = Uri.parse("http://cs.annauniv.edu/academic/ug2012/M1.pdf");
		//Intent webIntent = new Intent(Intent.ACTION_VIEW, webPage);
		//Intent downloadFileIntent;
        //downloadFileIntent = new Intent(getActivity(), Downloader.class);
        //downloadFileIntent.
       // startActivity(webIntent);
		return inflater.inflate(R.layout.secont, null);
	}

	
}
