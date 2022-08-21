package com.alfan.cashbooksertifikasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alfan.cashbooksertifikasi.Adapter.listAdapter;
import com.alfan.cashbooksertifikasi.DB.DBHelper;
import com.alfan.cashbooksertifikasi.Models.DetailModel;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    DBHelper db;
    RecyclerView recyclerView;
    private ArrayList<DetailModel> DetailArrayList;

    listAdapter adptr;
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        recyclerView = (RecyclerView)findViewById(R.id.recycleview);
        btn_back = findViewById(R.id.btn_back);

        DetailArrayList = new ArrayList<>();
        db = new DBHelper(DetailActivity.this);

        DetailArrayList = db.detail();

        adptr = new listAdapter(DetailArrayList, DetailActivity.this);
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DetailActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adptr);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_back();
            }
        });

    }

    private void btn_back() {
        Intent backIntent = new Intent(DetailActivity.this, MainActivity.class);
        startActivity(backIntent);
        finish();
    }
}