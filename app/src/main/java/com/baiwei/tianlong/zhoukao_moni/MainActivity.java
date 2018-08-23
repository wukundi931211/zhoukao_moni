package com.baiwei.tianlong.zhoukao_moni;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.baiwei.tianlong.zhoukao_moni.adapter.LieBiaoAdapter;
import com.baiwei.tianlong.zhoukao_moni.adapter.SheJiShiAdapter;
import com.baiwei.tianlong.zhoukao_moni.base.BaseActivity;
import com.baiwei.tianlong.zhoukao_moni.mvp.main.model.beans.LieBiaoBeans;
import com.baiwei.tianlong.zhoukao_moni.mvp.main.model.beans.LunBoBeans;
import com.baiwei.tianlong.zhoukao_moni.mvp.main.model.beans.SheJiBeans;
import com.baiwei.tianlong.zhoukao_moni.mvp.tusan.model.beans.TuSanBeans;
import com.baiwei.tianlong.zhoukao_moni.mvp.main.presenter.ZhouKaoPresenter;
import com.baiwei.tianlong.zhoukao_moni.mvp.main.view.ZhouKaoView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<ZhouKaoPresenter> implements ZhouKaoView {
    private static final String TAG = "MainAtivity";
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.sheji)
    RecyclerView sheji;
    @BindView(R.id.liebiao)
    RecyclerView liebiao;


    private List<String> listLunBo = new ArrayList<>();
    private List<String> titles = new ArrayList<>();


    //注入p
    @Override
    protected ZhouKaoPresenter providePresenter() {
        return new ZhouKaoPresenter(this);
    }

    @Override
    protected Activity provideBindView() {
        return this;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        super.initData();
        if (presenter!=null){
            presenter.getLunBo();
        }
    }


    //轮播
    @Override
    public void getLunBoSuccess(final LunBoBeans lunBoBeans) {

        List<LunBoBeans.DataBean> data = lunBoBeans.getData();

        for (int i = 0; i < data.size(); i++) {
            String icon = data.get(i).getIcon();
            String title = data.get(i).getTitle();
            String url = data.get(i).getUrl();
            listLunBo.add(icon);
            titles.add(title);
        }
        banner.setImageLoader(new MyLoader());
        banner.setImages(listLunBo);
        banner.setDelayTime(2000);
        banner.setBannerTitles(titles);
        banner.setBannerAnimation(Transformer.BackgroundToForeground);
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        banner.start();

        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                final String url = lunBoBeans.getData().get(position).getUrl();
                Intent intent  = new Intent(MainActivity.this,WebActivity.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        presenter.getSheJi();
    }

    @Override
    public void getLunBoError(String error) {
        Log.d(TAG, "getLunBoError: " + error);
    }


    //设计师
    @Override
    public void getSheJiSuccess(SheJiBeans sheJiBeans) {
        List<SheJiBeans.DataBean.DisplayBean> display = sheJiBeans.getData().getDisplay();
        
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        sheji.setLayoutManager(linearLayoutManager);
        SheJiShiAdapter adapter = new SheJiShiAdapter(display,this);
        sheji.setAdapter(adapter);

        presenter.getLieBiao();
        
    }

    @Override
    public void getSheJiError(String error) {
        Log.d(TAG, "getSheJiError: " + error);
    }
    
    
    //列表
    @Override
    public void getLieBiaoSuccess(LieBiaoBeans lieBiaoBeans) {
        List<LieBiaoBeans.DataBean> data = lieBiaoBeans.getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        liebiao.setLayoutManager(linearLayoutManager);
        LieBiaoAdapter lieBiaoAdapter = new LieBiaoAdapter(data,this);
        liebiao.setAdapter(lieBiaoAdapter);

        lieBiaoAdapter.setOnItemLieBiaoInstance(new LieBiaoAdapter.OnItemLieBiaoInstance() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent  = new Intent(MainActivity.this,TuSanActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void getLieBiaoError(String error) {
        Log.d(TAG, "getLieBiaoError: " + error);
    }



    @Override
    public Context context() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    //图片加载
    private class MyLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            imageView.setImageURI(Uri.parse((String) path));
        }

        @Override
        public ImageView createImageView(Context context) {
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context);
            return simpleDraweeView;
        }
    }
}
