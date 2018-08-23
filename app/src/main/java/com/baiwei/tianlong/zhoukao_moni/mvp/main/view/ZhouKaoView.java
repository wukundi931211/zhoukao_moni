package com.baiwei.tianlong.zhoukao_moni.mvp.main.view;

import com.baiwei.tianlong.zhoukao_moni.base.View;
import com.baiwei.tianlong.zhoukao_moni.mvp.main.model.beans.LieBiaoBeans;
import com.baiwei.tianlong.zhoukao_moni.mvp.main.model.beans.LunBoBeans;
import com.baiwei.tianlong.zhoukao_moni.mvp.main.model.beans.SheJiBeans;
import com.baiwei.tianlong.zhoukao_moni.mvp.tusan.model.beans.TuSanBeans;

public interface ZhouKaoView extends View {
    //轮播
    void getLunBoSuccess(LunBoBeans lunBoBeans);

    void getLunBoError(String error);

    //设计师
    void  getSheJiSuccess(SheJiBeans sheJiBeans);

    void getSheJiError(String error);

    //列表
    void getLieBiaoSuccess(LieBiaoBeans lieBiaoBeans);

    void getLieBiaoError(String error);


}
