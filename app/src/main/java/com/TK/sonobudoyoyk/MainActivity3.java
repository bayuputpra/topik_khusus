package com.TK.sonobudoyoyk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.TK.sonobudoyoyk.adapter.ListAdapter;
import com.TK.sonobudoyoyk.model.ActivityDetail;
import com.TK.sonobudoyoyk.model.news;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    private RecyclerView rvNews;
    private ArrayList<news> List = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        rvNews=findViewById(R.id.rv_news);
        rvNews.setHasFixedSize(true);

        List.addAll(getList());
        showRecycleList();
    }

    private void showRecycleList() {
        rvNews.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter listAdapter = new ListAdapter(List);
        rvNews.setAdapter(listAdapter);

        listAdapter.setOnItemClick((data -> {
            showSelectedBook(data);
        }));

    }

    private void showSelectedBook(news data) {
        //Toast.makeText(this,data.getTitle(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ActivityDetail.class);

        intent.putExtra("foto_news", data.getFoto());
        intent.putExtra("title_news", data.getTitle());
        intent.putExtra("desc_news", data.getDescription());

        this.startActivity(intent);
    }

    public ArrayList<news> getList() {
        String[] dataTitle=getResources().getStringArray(R.array.data_title);
        String[] dataDesc=getResources().getStringArray(R.array.data_description);
        String[] dataFoto=getResources().getStringArray(R.array.data_foto);

        ArrayList<news> ListNews=new ArrayList<>();
        for (int i = 0; i<dataTitle.length;i++){
            news news = new news();
            news.setTitle(dataTitle[i]);
            news.setDescription(dataDesc[i]);
            news.setFoto(dataFoto[i]);

            ListNews.add(news);
        }
        return ListNews;
    }

    public void back(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
        finish();
    }
}