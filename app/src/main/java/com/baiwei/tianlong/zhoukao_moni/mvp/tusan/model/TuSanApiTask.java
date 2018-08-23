package com.baiwei.tianlong.zhoukao_moni.mvp.tusan.model;

import com.baiwei.tianlong.zhoukao_moni.mvp.main.model.ModelApi;
import com.baiwei.tianlong.zhoukao_moni.mvp.tusan.model.beans.TuSanBeans;
import com.baiwei.tianlong.zhoukao_moni.utils.RetrofitcManager;

import io.reactivex.Flowable;

public class TuSanApiTask implements TuSanApi {
    @Override
    public Flowable<TuSanBeans> getTuSans(int pscid) {
        return RetrofitcManager.getDefault().create(TuSanApi.class).getTuSans(pscid);
    }
}
