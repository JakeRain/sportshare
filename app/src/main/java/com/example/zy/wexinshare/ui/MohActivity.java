package com.example.zy.wexinshare.ui;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.zy.wexinshare.R;

public class MohActivity extends AppCompatActivity {
    RecyclerView listview;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moh);
        listview = (RecyclerView)findViewById(R.id.recyclerview);


    }
}
