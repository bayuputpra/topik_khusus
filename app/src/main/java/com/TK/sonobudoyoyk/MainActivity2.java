package com.TK.sonobudoyoyk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void scan(View view) {
        Intent intent = new Intent(this,scan.class);
        startActivity(intent);
    }

    public void news(View view) {
        Intent intent = new Intent(this,MainActivity3.class);
        startActivity(intent);
    }

    public void contact(View view) {
        Intent intent = new Intent(this,contact.class);
        startActivity(intent);
    }

    public void map(View view) {
        Intent intent = new Intent(this,map.class);
        startActivity(intent);
    }

    public void story(View view) {
        Intent intent = new Intent(this,sejarah.class);
        startActivity(intent);
    }

    public void report(View view) {
        Intent intent = new Intent(this,report.class);
        startActivity(intent);
    }
}