package com.android.pet.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.doepiccoding.navigationdrawer.R;
import com.joanzapata.pdfview.PDFView;

import java.io.File;


public class M2Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.maths2x, null);
        //TextView.class.cast(rootView.findViewById(R.id.labelText)).setText("Venus");
        String url = "http://cs.annauniv.edu/academic/ug2012/M2.pdf";

        PDFView pdfView = (PDFView) rootView.findViewById(R.id.pdfView);

        FileDownloader fileDownloader = new FileDownloader();
        File file = new File(fileDownloader.getFilePath("/SYLAB/M2.pdf"));

        if(fileDownloader.isReadyForDownload(null, this, "/SYLAB/M2.pdf")) {
            fileDownloader.DownloadSyllabus(getActivity().getApplicationContext(), url, "M2");

        }
        else {
            if(!fileDownloader.getmConnected()) {
                Toast.makeText(getActivity().getApplicationContext(), "Network error", Toast.LENGTH_SHORT).show();
                if(fileDownloader.isFileAlreadyPresent("/SYLAB/M2.pdf")) {
                    pdfView.fromFile(file).defaultPage(1).enableSwipe(true).load();
                }
            }
            if(!fileDownloader.getmFileStatus()) {
                Toast.makeText(getActivity().getApplicationContext(), "File already downloaded", Toast.LENGTH_SHORT).show();

                pdfView.fromFile(file).defaultPage(1).enableSwipe(true).load();
            }
        }

        return rootView;
    }


}