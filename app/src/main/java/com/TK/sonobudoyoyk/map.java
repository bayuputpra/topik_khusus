package com.TK.sonobudoyoyk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
    }

    public void back(View view) {
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
        finish();
    }
}