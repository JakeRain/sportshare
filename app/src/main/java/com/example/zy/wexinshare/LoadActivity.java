package com.example.zy.wexinshare;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.zy.wexinshare.adapter.CircleListAdapter;
import com.example.zy.wexinshare.adapter.MyAdapter;
import com.example.zy.wexinshare.bean.MyCircle;
import com.example.zy.wexinshare.net.GetCircle;

import java.util.List;

/**
 * RecyclerView以瀑布流的方式展示数据
 * 要展示的数据：
 * 1、产品名称
 * 2、产品朋友圈文案
 * 3、产品的图片
 */
public class LoadActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;

    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        //initView();
        initData();
    }
//    private void initView(){
//        mRecyclerView = (RecyclerView) findViewById(R.id.rclistview);
//        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);//定义瀑布流管理器，第一个参数是列数，第二个是方向。
//        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);//不设置的话，图片闪烁错位，有可能有整列错位的情况。
//        mRecyclerView.setLayoutManager(layoutManager);//设置瀑布流管理器
//        //mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(0,1,false));//边距和分割线，需要自己定义
//        mRecyclerView.setAdapter(new MyAdapter(this));//设置适配器
//        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                layoutManager.invalidateSpanAssignments();//这行主要解决了当加载更多数据时，底部需要重绘，否则布局可能衔接不上。
//            }
//        });
//
//    }

    private void initData(){
        new GetCircle().getCircle(new Handler(){
            @Override
            public void dispatchMessage(Message msg) {
                super.dispatchMessage(msg);

                if(msg.what == 1) {
                    mRecyclerView = (RecyclerView) findViewById(R.id.rclistview);
                    final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);//定义瀑布流管理器，第一个参数是列数，第二个是方向。
                    layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);//不设置的话，图片闪烁错位，有可能有整列错位的情况。
                    mRecyclerView.setLayoutManager(layoutManager);//设置瀑布流管理器
                    List<MyCircle> beans = (List<MyCircle>) msg.obj;
                    CircleListAdapter adapter = new CircleListAdapter(beans,LoadActivity.this);
                    mRecyclerView.setAdapter(adapter);
                    mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                            super.onScrollStateChanged(recyclerView, newState);
                            layoutManager.invalidateSpanAssignments();//这行主要解决了当加载更多数据时，底部需要重绘，否则布局可能衔接不上。
                        }
                    });
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
