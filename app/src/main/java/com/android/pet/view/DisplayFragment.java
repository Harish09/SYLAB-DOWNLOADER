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
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DisplayFragment extends Fragment {

    private static final String ARG_PARAM1 = "fileName";
    private static final String ARG_PARAM2 = "url";

    private String myFileName;
    private String url;

    private FileDownloader fileDownloader = null;
    private File file = null;

    public boolean URLIsReachable(String urlString)
    { int responseCode;
        try
        {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url
                    .openConnection();
            responseCode = urlConnection.getResponseCode();
            urlConnection.disconnect();
            return responseCode != 200;
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
            return false;
        } catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    public static DisplayFragment newInstance(String url, String fileName) {

        DisplayFragment fragment = new DisplayFragment();

        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, fileName);
        args.putString(ARG_PARAM2, url);

        fragment.setArguments(args);

        return fragment;

    }

    public DisplayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            myFileName = getArguments().getString(ARG_PARAM1);
            url = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            View rootView;
            rootView = inflater.inflate(R.layout.m2, null);
            //TextView.class.cast(rootView.findViewById(R.id.labelText)).setText("Venus");

        if(!URLIsReachable(url))

        {
            Toast.makeText(getActivity().getApplicationContext(), "Coming Sooooooon...", Toast.LENGTH_SHORT).show();
            rootView = inflater.inflate(R.layout.comingsoon, null);
            return rootView;
        }

        fileDownloader = new FileDownloader();
            file = new File(fileDownloader.getFilePath("/sylab/" + myFileName + ".pdf"));

            PDFView pdfView = (PDFView) rootView.findViewById(R.id.pdfView);

            Button temp = (Button) getActivity().findViewById(R.id.open_btn);

            temp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent target = new Intent(Intent.ACTION_VIEW);
                    target.setDataAndType(Uri.fromFile(file), "application/pdf");
                    target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

                    Intent intent = Intent.createChooser(target, "Open File");
                    try {
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(getActivity().getApplicationContext(), "No other application for viewing PDFs", Toast.LENGTH_SHORT).show();
                    }

                }
            });

            if (fileDownloader.isReadyForDownload(this) && !fileDownloader.isFilePresent(file)) {
                fileDownloader.DownloadFile(getActivity().getApplicationContext(), url, "/sylab/", myFileName, ".pdf");

            } else {
                if (fileDownloader.isFilePresent("/sylab/" + myFileName + ".pdf")) {
                    Toast.makeText(getActivity().getApplicationContext(), "File already downloaded", Toast.LENGTH_SHORT).show();
                    temp.setVisibility(View.VISIBLE);

                    pdfView.fromFile(file).defaultPage(1).enableSwipe(true).load();
                    return rootView;
                }

                if (!fileDownloader.getDeviceConnectedState()) {

                    Toast.makeText(getActivity().getApplicationContext(), "Network error", Toast.LENGTH_SHORT).show();

                    if (fileDownloader.isFilePresent("/sylab/" + myFileName + ".pdf")) {

                        temp.setVisibility(View.VISIBLE);
                        pdfView.fromFile(file).defaultPage(1).enableSwipe(true).load();
                        return rootView;
                    }

                }

            }

        return rootView;
    }

}

