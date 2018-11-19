package com.example.zy.wexinshare;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.example.zy.wexinshare.adapter.CircleListAdapter;
import com.example.zy.wexinshare.bean.MyCircle;
import com.example.zy.wexinshare.net.GetCircle;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView以瀑布流的方式展示数据
 * 要展示的数据：
 * 1、产品名称
 * 2、产品朋友圈文案
 * 3、产品的图片
 */
public class LoadActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    CircleListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        initView();
        initData();
    }
    private void initView(){
        recyclerView = (RecyclerView)findViewById(R.id.rclistview);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
    }
    private void initData(){
        new GetCircle().getCircle(new Handler(){
            @Override
            public void dispatchMessage(Message msg) {
                super.dispatchMessage(msg);

                if(msg.what == 1) {
                    List<MyCircle> beans = (List<MyCircle>) msg.obj;
                    adapter = new CircleListAdapter(beans);
                    recyclerView.setAdapter(adapter);
                    Toast.makeText(LoadActivity.this, "一共请求到了这么多的数据"+beans.size(), Toast.LENGTH_SHORT).show();
                }else if(msg.what == 0){
                    Toast.makeText(LoadActivity.this, "数据请求失败", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoadActivity.this, "数据请求有误-----", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }


}
