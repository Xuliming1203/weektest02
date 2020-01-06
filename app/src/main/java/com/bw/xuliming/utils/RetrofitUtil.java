package com.bw.xuliming.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.bw.xuliming.api.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 时间：2020/1/6
 * 作者：徐黎明
 * 类的作用：
 */
public class RetrofitUtil {
    private static RetrofitUtil instance;
    private final Retrofit retrofit;

    public RetrofitUtil() {
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                //日志拦截器
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.Base_url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static RetrofitUtil getInstance() {
        if (instance == null) {
            synchronized (RetrofitUtil.class){
                if (instance == null) {
                    instance=new RetrofitUtil();
                }
            }
        }
        return instance;
    }
    public boolean hasnet(Context context){
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            return true;
        }else {
            return false;
        }
    }
    public <T>T createservice(Class<T> tClass){
        T t=retrofit.create(tClass);
        return t;
    }
}
