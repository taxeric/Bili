package com.lanier.bili.login;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lanier.bili.R;
import com.lanier.bili.utils.CookieUtils;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initWebView();
    }

    @SuppressLint("SetJavaScriptEnabled")
    void initWebView(){
        WebView webView = findViewById(R.id.main_wv);
        String url = "https://m.bilibili.com";

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
        webView.loadUrl(url);
    }

    @Override
    protected void onPause() {
        super.onPause();
        CookieUtils.saveCookie("https://m.bilibili.com");
    }
}
