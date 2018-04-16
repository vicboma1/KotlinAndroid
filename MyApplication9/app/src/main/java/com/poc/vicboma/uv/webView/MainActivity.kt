package com.poc.vicboma.uv.webView

import android.app.Activity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     /*
        this.webview.settings.javaScriptEnabled = true
        this.webview.webViewClient = WebViewClient()
        this.webview.loadUrl("https://www.google.es")
     */

        //Apply allow us to access the internal properties of the object
        //Calls the specified function block with this value as its receiver and returns this value.
        this.webview.apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
            loadUrl("https://www.google.es")
        }
    }
}
