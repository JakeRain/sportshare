package com.example.zy.wexinshare.net;

import android.os.Handler;
import android.os.Message;

import com.example.zy.wexinshare.bean.MyCircle;
import com.example.zy.wexinshare.bean.TonicBean;
import com.example.zy.wexinshare.config.GeneralConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetCircle {


    public void getCircle(final Handler handler){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GeneralConfig.URL_HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         retrofit.create(CircleServlice.class)
                .getTonicBean()
                //进行网络请求
                .enqueue(new Callback<List<MyCircle>>() {
                    @Override
                    public void onResponse(Call<List<MyCircle>> call, Response<List<MyCircle>> response) {
                        List<MyCircle> beans = response.body();
                        Message msg = handler.obtainMessage();
                        msg.obj = beans;
                        msg.what = 1;
                        handler.sendMessage(msg);
                    }

                    @Override
                    public void onFailure(Call<List<MyCircle>> call, Throwable t) {
                    Message msg = handler.obtainMessage();
                    msg.what = 0;
                    handler.sendMessage(msg);
                    }
                });

    }
}
