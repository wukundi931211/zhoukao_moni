package com.baiwei.tianlong.zhoukao_moni.mvp.tusan.presenter;

import com.baiwei.tianlong.zhoukao_moni.base.BasePresenter;
import com.baiwei.tianlong.zhoukao_moni.mvp.main.view.ZhouKaoView;
import com.baiwei.tianlong.zhoukao_moni.mvp.tusan.model.TuSanApiTask;
import com.baiwei.tianlong.zhoukao_moni.mvp.tusan.model.beans.TuSanBeans;
import com.baiwei.tianlong.zhoukao_moni.mvp.tusan.view.TuSanView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

public class TuSanPresenter extends BasePresenter<TuSanView> {

    private TuSanApiTask tuSanApiTask;

    public TuSanPresenter(TuSanView view) {
        super(view);
    }

    @Override
    protected void initModel() {
        tuSanApiTask = new TuSanApiTask();
    }

    //图三
    public void getTuSan(int pscid){
        tuSanApiTask.getTuSans(pscid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<TuSanBeans>() {
                    @Override
                    public void onNext(TuSanBeans tuSanBeans) {
                        if ("0".equals(tuSanBeans.getCode())){
                            if (view!=null){
                                view.getTuSanSuccess(tuSanBeans);
                            }
                        }else {
                            if (view!=null){
                                view.getTuSanError(tuSanBeans.getMsg());
                            }
                        }
                    }
                    @Override
                    public void onError(Throwable t) {
                        if (view!=null){
                            view.getTuSanError(t.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
