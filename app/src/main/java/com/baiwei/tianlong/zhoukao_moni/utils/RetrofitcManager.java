package com.baiwei.tianlong.zhoukao_moni.utils;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitcManager {
    private final Retrofit retrofit;



    private static class SingHolder{
        private static final RetrofitcManager INSTANT = new RetrofitcManager(ConstantApi.BASE_URL);
        private static final RetrofitcManager INSTANT1 = new RetrofitcManager(ConstantApi.BASE_URL1);
    }

    public static RetrofitcManager getDefault(){
        return SingHolder.INSTANT;
    }

    public static RetrofitcManager getDefault1(){
        return SingHolder.INSTANT1;
    }

    public RetrofitcManager(String baseUrl) {
        this.retrofit = new Retrofit.Builder()
                            .baseUrl(baseUrl)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
    }

    //网络拦截器
    private OkHttpClient buildOkHttpClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("xxx", "日志信息：" + message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();

    }
    public <T> T create(Class<T> tClass) {
        return retrofit.create(tClass);
    }


}
