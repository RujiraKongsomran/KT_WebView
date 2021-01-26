package com.rujirakongsomran.kt_webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.rujirakongsomran.kt_webview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        webViewSetup()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun webViewSetup() {

        // Handling page navigation
        binding.wv.webViewClient = WebViewClient()
        binding.wv.apply {
            binding.wv.loadUrl("http://www.google.com")
            // Enabling JavaScript
            binding.wv.settings.javaScriptEnabled = true
            binding.wv.settings.safeBrowsingEnabled = true
        }
    }

    override fun onBackPressed() {
        if (binding.wv.canGoBack()) binding.wv.goBack() else super.onBackPressed()
    }
}