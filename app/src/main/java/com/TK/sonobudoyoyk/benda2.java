package com.TK.sonobudoyoyk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class benda2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benda2);
    }

    public void back(View view) {
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
        finish();
    }
}