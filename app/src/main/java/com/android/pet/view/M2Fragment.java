package com.android.pet.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.doepiccoding.navigationdrawer.R;

public class M2Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.maths2x, null);
        //TextView.class.cast(rootView.findViewById(R.id.labelText)).setText("Venus");
        String url = "http://cs.annauniv.edu/academic/ug2012/M2.pdf";

        FileDownloader fileDownloader = new FileDownloader();

        if(fileDownloader.isReadyForDownload(null, this, "/SYLAB/M2.pdf")) {
            fileDownloader.DownloadSyllabus(getActivity().getApplicationContext(), url, "M2");
        }
        else {
            if(!fileDownloader.getmConnected()) {
                Toast.makeText(getActivity().getApplicationContext(), "Network error", Toast.LENGTH_SHORT).show();
            }
            if(!fileDownloader.getmFileStatus()) {
                Toast.makeText(getActivity().getApplicationContext(), "File already downloaded", Toast.LENGTH_SHORT).show();
            }
        }

        return rootView;
    }


}