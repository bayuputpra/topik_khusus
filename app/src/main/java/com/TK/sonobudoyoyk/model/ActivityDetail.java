package com.TK.sonobudoyoyk.model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.TK.sonobudoyoyk.MainActivity3;
import com.TK.sonobudoyoyk.R;
import com.bumptech.glide.Glide;

public class ActivityDetail extends AppCompatActivity {
    ImageView imageNews;
    TextView tvTitle,tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageNews=findViewById(R.id.imageNews);
        tvTitle=findViewById(R.id.tvTitle);
        tvDesc=findViewById(R.id.tvDesc);

        getIncomingExtra();
    }

    private void getIncomingExtra(){
        if (getIntent().hasExtra("foto_news") && getIntent().hasExtra("title_news") && getIntent().hasExtra("desc_news")){
            String data_foto=getIntent().getStringExtra("foto_news");
            String data_title=getIntent().getStringExtra("title_news");
            String data_description=getIntent().getStringExtra("desc_news");

            setActivityData(data_foto,data_title,data_description);

        }
    }

    private void setActivityData(String data_foto, String data_title, String data_description) {
        Glide.with(this).load(data_foto)
                .into(imageNews);
        tvTitle.setText(data_title);
        tvDesc.setText(data_description);
    }

    public void back(View view) {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
        finish();
    }
}