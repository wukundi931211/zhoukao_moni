package com.baiwei.tianlong.zhoukao_moni;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebActivity extends AppCompatActivity {

    private static final String TAG = "WebAtivity";

    @BindView(R.id.web)
    WebView web;
    @BindView(R.id.fanhui)
    Button fanhui;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);

        int taskId = getTaskId();

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        Toast.makeText(this,url,Toast.LENGTH_SHORT).show();


        web.loadUrl(url);
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }



    @OnClick(R.id.fanhui)
    public void onViewClicked() {
        Intent intent = new Intent();
        setResult(2,intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        web.removeAllViews();
        web.destroy();
    }
}
