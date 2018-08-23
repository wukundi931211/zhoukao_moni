package com.baiwei.tianlong.zhoukao_moni;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.baiwei.tianlong.zhoukao_moni.adapter.TuSanAdapter;
import com.baiwei.tianlong.zhoukao_moni.base.BaseActivity;
import com.baiwei.tianlong.zhoukao_moni.mvp.tusan.model.beans.TuSanBeans;
import com.baiwei.tianlong.zhoukao_moni.mvp.tusan.presenter.TuSanPresenter;
import com.baiwei.tianlong.zhoukao_moni.mvp.tusan.view.TuSanView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TuSanActivity extends BaseActivity<TuSanPresenter> implements TuSanView {


    @BindView(R.id.tusan)
    RecyclerView tusan;

    @Override
    protected TuSanPresenter providePresenter() {
        return new TuSanPresenter(this);
    }

    @Override
    protected Activity provideBindView() {
        return this;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_tu_san;
    }

    @Override
    protected void initData() {
        super.initData();
        presenter.getTuSan(1);
    }

    @Override
    public void getTuSanSuccess(TuSanBeans tuSanBeans) {
        List<TuSanBeans.DataBean> data = tuSanBeans.getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        tusan.setLayoutManager(linearLayoutManager);


        TuSanAdapter tuSanAdapter = new TuSanAdapter(data, this);
        tusan.setAdapter(tuSanAdapter);


    }

    @Override
    public void getTuSanError(String error) {

    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
