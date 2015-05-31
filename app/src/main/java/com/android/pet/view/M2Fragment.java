package com.android.pet.view;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.doepiccoding.navigationdrawer.R;
import com.joanzapata.pdfview.PDFView;

import java.io.File;


public class M2Fragment extends Fragment {

    FileDownloader fileDownloader = null;
    File file = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        this.setHasOptionsMenu(true);

        View rootView = inflater.inflate(R.layout.m2, null);
        //TextView.class.cast(rootView.findViewById(R.id.labelText)).setText("Venus");
        String url = "http://cs.annauniv.edu/academic/ug2012/M2.pdf";

        fileDownloader = new FileDownloader();
        file = new File(fileDownloader.getFilePath("/SYLAB/M2.pdf"));

        PDFView pdfView = (PDFView) rootView.findViewById(R.id.pdfView);

        Button temp = (Button) getActivity().findViewById(R.id.open_btn);

        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent target = new Intent(Intent.ACTION_VIEW);
                target.setDataAndType(Uri.fromFile(file),"application/pdf");
                target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

                Intent intent = Intent.createChooser(target, "Open File");
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getActivity().getApplicationContext(), "No other application for viewing PDFs", Toast.LENGTH_SHORT).show();
                }

            }
        });


        if(fileDownloader.isReadyForDownload(this) && !fileDownloader.isFilePresent(file)) {
            fileDownloader.DownloadFile(getActivity().getApplicationContext(), url, "/SYLAB/", "M2", ".pdf");

        }
        else {
            if(fileDownloader.isFilePresent("/SYLAB/M2.pdf")) {
                Toast.makeText(getActivity().getApplicationContext(), "File already downloaded", Toast.LENGTH_SHORT).show();
                temp.setVisibility(View.VISIBLE);

                pdfView.fromFile(file).defaultPage(1).enableSwipe(true).load();
                return rootView;
            }

            if(!fileDownloader.getDeviceConnectedState()) {
                Toast.makeText(getActivity().getApplicationContext(), "Network error", Toast.LENGTH_SHORT).show();
                if(fileDownloader.isFilePresent("/SYLAB/M2.pdf")) {
                    temp.setVisibility(View.VISIBLE);
                    pdfView.fromFile(file).defaultPage(1).enableSwipe(true).load();
                    return rootView;
                }
            }

        }


        return rootView;
    }

}