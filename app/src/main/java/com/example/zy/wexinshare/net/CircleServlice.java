package com.example.zy.wexinshare.net;

import com.example.zy.wexinshare.bean.MyCircle;
import com.example.zy.wexinshare.bean.TonicBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CircleServlice {
    // 获取健身产品及文案的json数据
    @GET("GetCircleServlet")
    Call<List<MyCircle>> getTonicBean();
    @GET("GetPICServlet")
    Call<List<String>> getPics();
}
