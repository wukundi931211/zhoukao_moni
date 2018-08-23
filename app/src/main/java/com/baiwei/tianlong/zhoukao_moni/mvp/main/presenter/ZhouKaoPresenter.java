package com.baiwei.tianlong.zhoukao_moni.mvp.main.presenter;

import com.baiwei.tianlong.zhoukao_moni.base.BasePresenter;

import com.baiwei.tianlong.zhoukao_moni.mvp.main.model.ModelApiTask;
import com.baiwei.tianlong.zhoukao_moni.mvp.main.model.beans.LieBiaoBeans;
import com.baiwei.tianlong.zhoukao_moni.mvp.main.model.beans.LunBoBeans;
import com.baiwei.tianlong.zhoukao_moni.mvp.main.model.beans.SheJiBeans;
import com.baiwei.tianlong.zhoukao_moni.mvp.tusan.model.beans.TuSanBeans;
import com.baiwei.tianlong.zhoukao_moni.mvp.main.view.ZhouKaoView;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

public class ZhouKaoPresenter extends BasePresenter<ZhouKaoView> {

    private ModelApiTask modelApiTask;

    public ZhouKaoPresenter(ZhouKaoView view) {
        super(view);
    }

    @Override
    protected void initModel() {
        modelApiTask = new ModelApiTask();
    }

    //轮播图
    public void getLunBo(){
        modelApiTask.getLunBo()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableSubscriber<LunBoBeans>() {
                        @Override
                        public void onNext(LunBoBeans lunBoBeans) {
                            if ("0".equals(lunBoBeans.getCode())){
                                if (view!=null){
                                    view.getLunBoSuccess(lunBoBeans);
                                }

                            }else {
                                if (view!=null){
                                    view.getLunBoError(lunBoBeans.getMsg());
                                }
                            }
                        }

                        @Override
                        public void onError(Throwable t) {
                            if (view!=null){
                                view.getLunBoError(t.toString());
                            }
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
    }
    //列表
    public void getLieBiao(){
        modelApiTask.getLieBiao()
                     .subscribeOn(Schedulers.io())
                     .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableSubscriber<LieBiaoBeans>() {
                    @Override
                    public void onNext(LieBiaoBeans lieBiaoBeans) {
                        if ("0".equals(lieBiaoBeans.getCode())){
                            if (view!=null){
                                view.getLieBiaoSuccess(lieBiaoBeans);
                            }
                        }else {
                            if (view!=null){
                                view.getLieBiaoError(lieBiaoBeans.getMsg());
                            }
                        }
                    }
                    @Override
                    public void onError(Throwable t) {
                        if (view!=null){
                            view.getLieBiaoError(t.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //设计
    public void getSheJi(){
        modelApiTask.getSheJi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<SheJiBeans>() {
                    @Override
                    public void onNext(SheJiBeans sheJiBeans) {
                        if ("1".equals(sheJiBeans.getCode())){
                            if (view!=null){
                                view.getSheJiSuccess(sheJiBeans);
                            }
                        }else {
                            if (view!=null){
                                view.getSheJiError(sheJiBeans.getMessage());
                            }
                        }
                    }
                    @Override
                    public void onError(Throwable t) {
                        if (view!=null){
                            view.getSheJiError(t.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
