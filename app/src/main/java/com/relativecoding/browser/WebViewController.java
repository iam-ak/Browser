package com.relativecoding.browser;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewController extends WebViewClient {

    ProgressDialog progressDialog;
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);

        if(progressDialog==null) {
            progressDialog = new ProgressDialog(view.getContext());
            progressDialog.show();
            ;
        }

    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        if(progressDialog!=null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

}
