package com.baiwei.tianlong.zhoukao_moni.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    protected  P prsenter;

    private View view;

    private Unbinder unbinder;

    @Nullable
    @Override
    public android.view.View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //加载布局
        if (view == null){
            view = inflater.inflate(provideFragmentLayoutID(), container, false);
        }
        ViewGroup parent = (ViewGroup) view.getParent();

        if (parent!= null){
            parent.removeView(view);
        }

        //ButterKifer
        unbinder = ButterKnife.bind(provideBindView(),view);
        return view;

    }

    protected abstract Object provideBindView();

    protected abstract int provideFragmentLayoutID();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prsenter = providePresenter();

        //初始化
        initView(view);
        initData();
        initListener();



    }

    protected void initListener() {
    }

    protected void initData() {
    }

    protected void initView(View view) {
    }

    protected abstract P providePresenter();

    @Override
    public void onDestroy() {
        prsenter.onDestory();
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //Fresco 清理缓存
//        ImagePipeline imagePipeline = Fresco.getImagePipeline();
//        imagePipeline.clearMemoryCaches();
//        imagePipeline.clearDiskCaches();
//        imagePipeline.clearCaches();

        unbinder.unbind();
    }
}
