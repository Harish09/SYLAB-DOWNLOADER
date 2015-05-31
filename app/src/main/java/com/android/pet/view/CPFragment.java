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

public class CPFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.s2physicsx, null);


        String url = "http://cs.annauniv.edu/academic/ug2012/CP.pdf";

        PDFView pdfView = (PDFView) rootView.findViewById(R.id.pdfView);

        FileDownloader fileDownloader = new FileDownloader();
        final File file = new File(fileDownloader.getFilePath("/SYLAB/CP.pdf"));

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
            fileDownloader.DownloadFile(getActivity().getApplicationContext(), url, "/SYLAB/", "CP", ".pdf");

        }
        else {
            if(fileDownloader.isFilePresent("/SYLAB/CP.pdf")) {
                Toast.makeText(getActivity().getApplicationContext(), "File already downloaded", Toast.LENGTH_SHORT).show();
                temp.setVisibility(View.VISIBLE);

                pdfView.fromFile(file).defaultPage(1).enableSwipe(true).load();
                return rootView;
            }

            if(!fileDownloader.getDeviceConnectedState()) {
                Toast.makeText(getActivity().getApplicationContext(), "Network error", Toast.LENGTH_SHORT).show();
                if(fileDownloader.isFilePresent("/SYLAB/CP.pdf")) {
                    temp.setVisibility(View.VISIBLE);
                    pdfView.fromFile(file).defaultPage(1).enableSwipe(true).load();
                    return rootView;
                }
            }

        }


        return rootView;
    }
}