package com.TK.sonobudoyoyk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class scan extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    Class newclass = null;
    final Activity thisActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult) {
        Log.v("TAG", rawResult.getText()); // Prints scan results
        Log.v("TAG", rawResult.getBarcodeFormat().toString());
        String desc=rawResult.getText();
        String activityString="com.TK.sonobudoyoyk."+desc;
        try {
            newclass=Class.forName(activityString);
        }catch (ClassNotFoundException classNotFoundException){
            classNotFoundException.printStackTrace();
        }
        if(newclass != null) {
            Intent nextIntent = new Intent(thisActivity, newclass);
            startActivity(nextIntent);
        } else {
            Toast.makeText(getApplicationContext(),"barcode tidak valid",Toast.LENGTH_SHORT).show();
        }
        mScannerView.resumeCameraPreview(this);
    }

}