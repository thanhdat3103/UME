package com.example.ume;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                // Hiển thị thông báo lỗi
                Toast.makeText(WebViewActivity.this, "Failed to load the webpage", Toast.LENGTH_SHORT).show();
                // Kết thúc activity và quay về trang trước đó
                finish();
            }
        });

        if (getIntent().hasExtra("url")) {
            String url = getIntent().getStringExtra("url");
            webView.loadUrl(url);
        }
    }
}