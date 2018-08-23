package com.baiwei.tianlong.zhoukao_moni.mvp.main.model;

import com.baiwei.tianlong.zhoukao_moni.mvp.main.model.beans.LieBiaoBeans;
import com.baiwei.tianlong.zhoukao_moni.mvp.main.model.beans.LunBoBeans;
import com.baiwei.tianlong.zhoukao_moni.mvp.main.model.beans.SheJiBeans;

import com.baiwei.tianlong.zhoukao_moni.utils.ConstantApi;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ModelApi {

    //轮播
    @GET(ConstantApi.AD_URL)
    Flowable<LunBoBeans> getLunBo();

    //设计
    @GET(ConstantApi.SHE_JI)
    Flowable<SheJiBeans> getSheJi();

    //列表
    @GET(ConstantApi.CATAGORY_URL)
    Flowable<LieBiaoBeans> getLieBiao();



}
