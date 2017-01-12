package com.example.android.fingerprintdialog;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Jubaed on 12/9/16.
 */

public class SavePhotoTask extends AsyncTask<byte[], String, String> {
    @Override
    protected String doInBackground(byte[]... jpeg) {
//        File photo=new File(Environment.getExternalStorageDirectory(), "photo.jpg");
//        File photo=new File(Environment.DIRECTORY_PICTURES, "photo.jpg");

        File path = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File photo = new File(path, "photo.jpg");
        try {
            // Make sure the Pictures directory exists.
            path.mkdirs();
            photo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (photo.exists()) {
            photo.delete();
        }

        try {
            FileOutputStream fos=new FileOutputStream(photo.getPath());

            fos.write(jpeg[0]);
            fos.close();
            Log.d("PictureDemo", "Photo saved in " + photo.getAbsolutePath());
        }
        catch (java.io.IOException e) {
            Log.e("PictureDemo", "Exception in photoCallback", e);
        }

        return(null);
    }
}
