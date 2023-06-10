package com.TK.sonobudoyoyk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

    public void intagram(View view) {
        Uri uri = Uri.parse("https://www.instagram.com/sonobudoyo/");
        Intent instagram = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(instagram);
    }

    public void youtube(View view) {
        Uri uri = Uri.parse("https://www.youtube.com/channel/UC1z3H9hx20wLfjnE_QqAlZw");
        Intent youtube = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(youtube);
    }

    public void twitter(View view) {
        Uri uri = Uri.parse("https://twitter.com/sonobudoyo");
        Intent twitter = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(twitter);
    }

    public void facebook(View view) {
        Uri uri = Uri.parse("https://web.facebook.com/sonobudoyomuseum?_rdc=1&_rdr");
        Intent facebook = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(facebook);
    }

    public void whatsapp(View view) {
        Uri uri = Uri.parse("https://api.whatsapp.com/send?phone=+628819106109&text=Halo%20Sahabat%20Sonobudoyo,Terimakasih%20telah%20menghubungi%20kami,%20Tuliskan%20pesan%20anda%20dan%20akan%20di%20jawab%20pada%20jam%20operasional%20kantor%20setiap%20Senin-Jumat%20Pukul%2008.00-15.00%20WIB.%20Terimakasih%20!");
        Intent whatsapp = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(whatsapp);
    }

    public void telp(View view) {
        Uri uri = Uri.parse("tel:(0274)373617");
        Intent telp = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(telp);
    }
}