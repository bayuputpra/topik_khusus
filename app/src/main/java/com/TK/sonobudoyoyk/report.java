package com.TK.sonobudoyoyk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class report extends AppCompatActivity {
    FloatingActionButton fab_add;
    RecycleAdapter recycleAdapter;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    ArrayList<report_user> listReport;
    RecyclerView rv_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        fab_add = findViewById(R.id.fb_add);
        rv_view = findViewById(R.id.rv_view);

        RecyclerView.LayoutManager mLayout = new LinearLayoutManager(this);
        rv_view.setLayoutManager(mLayout);
        rv_view.setItemAnimator(new DefaultItemAnimator());

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogform dialogform = new Dialogform("","","","Tambah");
                dialogform.show(getSupportFragmentManager(),"form");
            }
        });

        show_data();
    }

    private void show_data(){
        database.child("Report_user").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listReport = new ArrayList<>();
                for (DataSnapshot item : snapshot.getChildren()){
                    report_user report = item.getValue(report_user.class);
                    report.setKey(item.getKey());
                    listReport.add(report);
                }

                recycleAdapter = new RecycleAdapter(listReport,report.this);
                rv_view.setAdapter(recycleAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void back(View view) {
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
}