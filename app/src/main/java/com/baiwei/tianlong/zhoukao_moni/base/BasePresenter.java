package com.baiwei.tianlong.zhoukao_moni.base;

import android.content.Context;

import com.baiwei.tianlong.zhoukao_moni.App;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<V extends View> {
    protected V view;

    //取消订阅
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public BasePresenter(V view) {
        this.view = view;
        initModel();
    }
    //注入model方法
    protected  abstract   void initModel();


    //处理内存溢出
    void onDestory(){
        view = null;
        compositeDisposable.clear();
    }

    protected Context context(){
        if (view!=null && view.context()!=null){
            return view.context();
        }else {
            return App.getAppContext();
        }
    }
}
