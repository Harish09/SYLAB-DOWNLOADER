package com.khf.inferno.sylab;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.third, null);
		Typeface tf2 = Typeface.createFromAsset(getActivity().getAssets(),
			"fonts/RobotoCondensed-Bold.ttf");
		TextView tv5 = (TextView) rootView.findViewById(R.id.textView16);
		tv5.setTypeface(tf2);
		TextView tv6 = (TextView) rootView.findViewById(R.id.textView17);
		tv6.setTypeface(tf2);
		//TextView.class.cast(rootView.findViewById(R.id.labelText)).setText("Earth");
		return rootView;
	}
}
