package com.baiwei.tianlong.zhoukao_moni.mvp.main.model;

import com.baiwei.tianlong.zhoukao_moni.mvp.main.model.beans.LieBiaoBeans;
import com.baiwei.tianlong.zhoukao_moni.mvp.main.model.beans.LunBoBeans;
import com.baiwei.tianlong.zhoukao_moni.mvp.main.model.beans.SheJiBeans;
import com.baiwei.tianlong.zhoukao_moni.utils.RetrofitcManager;

import io.reactivex.Flowable;

public class ModelApiTask implements ModelApi {
    @Override
    public Flowable<LunBoBeans> getLunBo() {
        return RetrofitcManager.getDefault().create(ModelApi.class).getLunBo();
    }

    @Override
    public Flowable<SheJiBeans> getSheJi() {
        return RetrofitcManager.getDefault1().create(ModelApi.class).getSheJi();
    }

    @Override
    public Flowable<LieBiaoBeans> getLieBiao() {
        return RetrofitcManager.getDefault().create(ModelApi.class).getLieBiao();
    }


}
