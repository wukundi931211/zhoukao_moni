package com.baiwei.tianlong.zhoukao_moni.mvp.tusan.model;

import com.baiwei.tianlong.zhoukao_moni.mvp.tusan.model.beans.TuSanBeans;
import com.baiwei.tianlong.zhoukao_moni.utils.ConstantApi;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TuSanApi {
    //图三
    @GET(ConstantApi.PRODUCTS_URL)
    Flowable<TuSanBeans> getTuSans(@Query("pscid") int pscid);
}
