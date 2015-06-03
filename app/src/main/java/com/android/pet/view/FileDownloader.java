package com.android.pet.view;

import android.app.Activity;
import android.app.DownloadManager;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.io.File;

public class FileDownloader {

    private ConnectivityManager connectivityManager;


    private Boolean mConnected = false, mFileStatus = false;


    public boolean isReadyForDownload(@Nullable Activity activity, @Nullable Fragment fragment, String pathRelativeToRoot) {

        if(fragment != null)
            connectivityManager = (ConnectivityManager) fragment.getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        if(activity != null)
            connectivityManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected())
            mConnected = true;
       // else
         //   Toast.makeText(fragment.getActivity().getApplicationContext(), "Network unavailable", Toast.LENGTH_SHORT).show();

        if (!isFileAlreadyPresent(pathRelativeToRoot))
            mFileStatus = true;
        //else
          //  Toast.makeText(fragment.getActivity().getApplicationContext(), "File already downloaded", Toast.LENGTH_SHORT).show();

        return mConnected && mFileStatus;
    }

    public Boolean getmConnected() {
        return mConnected;
    }

    public Boolean getmFileStatus() {
        return mFileStatus;
    }

    public boolean isFileAlreadyPresent(String pathRelativeToRoot) {

        String totalPath = Environment.getExternalStorageDirectory().toString() + pathRelativeToRoot;
        File checkFile = new File(totalPath);

        return checkFile.exists();
    }

    public String getFilePath(String pathRelativeToRoot) {
        return Environment.getExternalStorageDirectory().toString() + pathRelativeToRoot;
    }

    public void DownloadSyllabus(Context context, String url, String fileName) {

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setDescription("Required component of the application");
        request.setTitle("Syllabus.pdf");

        // in order for this if to run, you must use the android 3.2 to compile your app
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDestinationInExternalPublicDir("/SYLAB", fileName + ".pdf");

        // get download service and enqueue file
        DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);

        Toast.makeText(context, "File downloaded at " + Environment.getExternalStorageDirectory() + "/SYLAB", Toast.LENGTH_SHORT).show();
    }
}
