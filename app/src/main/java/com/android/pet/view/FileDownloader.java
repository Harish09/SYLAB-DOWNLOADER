package com.android.pet.view;

import android.app.Activity;
import android.app.DownloadManager;
import android.support.annotation.NonNull;
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

    private boolean deviceConnected = false;

    private boolean fileStatus = false;

    private String fileExtension = ".txt";

    private String fileName = "downloaded_file";

    private String dirName = "/file_downloader/";

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        if(fileExtension != null)
            this.fileExtension = fileExtension;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        if(fileName != null)
            this.fileName = fileName;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        if(dirName != null)
            this.dirName = dirName;
    }

    public void setDeviceConnected(boolean deviceConnected) {
        this.deviceConnected = deviceConnected;
    }

    public void setFileStatus(boolean fileStatus) {
        this.fileStatus = fileStatus;
    }

    public boolean getDeviceConnectedState() {
        return deviceConnected;
    }

    public boolean getFileStatus() {
        return fileStatus;
    }

    public boolean isReadyForDownload(@NonNull Object Parent) {

        if(Parent instanceof Fragment)
            connectivityManager = (ConnectivityManager) ((Fragment)Parent).getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        //if(fragment != null)

        if(Parent instanceof Activity)
            connectivityManager = (ConnectivityManager) ((Activity)Parent).getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected())
            setDeviceConnected(true);

        return getDeviceConnectedState();
    }


    public boolean isFilePresent(String pathRelativeToRoot) {
        String totalPath = Environment.getExternalStorageDirectory().toString() + pathRelativeToRoot;
        return new File(totalPath).exists();

    }

    public boolean isFilePresent(File file) {
        return file.exists();
    }

    public String getFilePath(String pathRelativeToRoot) {
        return Environment.getExternalStorageDirectory().toString() + pathRelativeToRoot;
    }

    public void DownloadFile(@NonNull Context context, @NonNull String url, @Nullable String dirName, @Nullable String fileName, @Nullable String fileExtension) {

        this.setDirName(dirName);
        this.setFileName(fileName);
        this.setFileExtension(fileExtension);

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setDescription("Required component of the application");
        request.setTitle("Syllabus.pdf");

        // in order for this if to run, you must use the android 3.2 to compile your app
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDestinationInExternalPublicDir(getDirName(), getFileName() + getFileExtension());

        // get download service and enqueue file
        DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);

        Toast.makeText(context, "File downloaded at " + Environment.getExternalStorageDirectory() + getDirName(), Toast.LENGTH_SHORT).show();
    }
}
