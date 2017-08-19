package com.xugongming38.job.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.xugongming38.job.R;


public class MainFragment extends Fragment {
    WebView webview;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //getActivity().getActionBar().setTitle("首页");

        view=inflater.inflate(R.layout.fragment_main, container, false);
        webview = (WebView) view.findViewById(R.id.web);
        WebSettings webSettings = webview .getSettings();
        webSettings.setJavaScriptEnabled(true);  //支持js
        webview.loadUrl("https://xugongming38.github.io/");
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
