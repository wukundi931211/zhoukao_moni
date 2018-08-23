package com.baiwei.tianlong.zhoukao_moni.mvp.tusan.view;

import com.baiwei.tianlong.zhoukao_moni.base.View;
import com.baiwei.tianlong.zhoukao_moni.mvp.tusan.model.beans.TuSanBeans;

public interface TuSanView extends View{

    //图三
    void getTuSanSuccess(TuSanBeans tuSanBeans);

    void getTuSanError(String error);
}
