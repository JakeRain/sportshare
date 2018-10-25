package com.example.zy.wexinshare;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.analytics.MobclickAgent;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTvShare;
    private TextView mTvShareText;
    private TextView mTvShareImg;
    private TextView mTvShareImgWeixin;
    private UMImage thumb;
    String iamge_url = "https://hbimg.b0.upaiyun.com/b3b8b5a85bdb328fd14cc1c2e93f07d911ed315b2f784-SPCBAH_fw658";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }


    private void initData() {

        if(Build.VERSION.SDK_INT>=23){
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CALL_PHONE,Manifest.permission.READ_LOGS,Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.SET_DEBUG_APP,Manifest.permission.SYSTEM_ALERT_WINDOW,Manifest.permission.GET_ACCOUNTS,Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this,mPermissionList,123);
        }
        thumb =  new UMImage(this, R.mipmap.ic_girl);
        thumb.setThumb(new UMImage(this, R.mipmap.share));

    }
    private void initView() {
        mTvShare = findViewById(R.id.tv_share);
        mTvShareText = findViewById(R.id.tv_share_text);
        mTvShareImg = findViewById(R.id.tv_share_img);
        mTvShareImgWeixin = findViewById(R.id.tv_share_img_weixin);
        mTvShare.setOnClickListener(this);
        mTvShareText.setOnClickListener(this);
        mTvShareImg.setOnClickListener(this);
        mTvShareImgWeixin.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_share:
                new ShareAction(MainActivity.this).withText("hello")
                        .setDisplayList(SHARE_MEDIA.WEIXIN,SHARE_MEDIA.WEIXIN_CIRCLE)
                        .setCallback(umShareListener).open();
                break;
            case R.id.tv_share_img_weixin:
                new ShareAction(MainActivity.this).withMedia(thumb)
                        .setPlatform(SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener).share();
                break;
            case R.id.tv_share_text:
                new ShareAction(MainActivity.this).withText("来自weishare的分享")
                        .setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)
                        .setCallback(umShareListener).share();
                break;
            case R.id.tv_share_img:
                new ShareAction(MainActivity.this).withMedia(thumb)
                        .setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)
                        .setCallback(umShareListener).share();
                break;
            default:
                break;
        }
    }

    private UMShareListener umShareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(MainActivity.this,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(MainActivity.this,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(MainActivity.this,"取消了",Toast.LENGTH_LONG).show();

        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(MainActivity.this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(MainActivity.this);
    }
}
