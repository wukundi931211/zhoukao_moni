package com.baiwei.tianlong.zhoukao_moni.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    //注入基类
    protected  P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(provideLayoutId());

        //ButterKnitfe
        ButterKnife.bind(provideBindView());


        initView();

        presenter = providePresenter();

        initData();

        initListener();
    }

    protected abstract P providePresenter();

    protected void initListener() {
    }

    protected void initData() {
    }

    protected  void initView(){

    };

    protected abstract Activity provideBindView();

    protected abstract int provideLayoutId();
}
