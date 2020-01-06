package com.bw.xuliming.api;

import com.bw.xuliming.entity.LeftEntity;
import com.bw.xuliming.entity.RigthEntity;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * 时间：2020/1/6
 * 作者：徐黎明
 * 类的作用：
 */
public interface ClsService {
    @GET("baweiapi/category")
    Observable<LeftEntity> getleft();
    @GET("baweiapi/shopByCategory")
    Observable<RigthEntity> getright(@QueryMap HashMap<String,String> parmas);

}
