package com.example.dogies;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class ChatBotActivity extends AppCompatActivity {

    private WebView webViewChat;
    private ProgressBar progressBarChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_maps);

        webViewChat = findViewById(R.id.webView);
        progressBarChat = findViewById(R.id.progressBar);

        webViewChat.getSettings().setJavaScriptEnabled(true);
        webViewChat.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBarChat.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBarChat.setVisibility(View.GONE);
            }
        });

        webViewChat.loadUrl("https://chatrace.com/webchat/?p=1968812&color=%23704B4B");
    }
}