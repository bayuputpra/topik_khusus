package com.TK.sonobudoyoyk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class MainActivity extends AppCompatActivity {
    ImageView GambarGif;
    private int waktu_loading=5200; // 2000 = 2 detik
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent pindah = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(pindah);
                finish();
            }
        },waktu_loading);

        GambarGif = (ImageView)findViewById(R.id.imgGif);

        Glide.with(MainActivity.this)
                .load(R.drawable.loadinggift)
                .asGif()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(GambarGif);
    }
}