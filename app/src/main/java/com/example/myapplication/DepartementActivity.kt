package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityDepartementBinding

class DepartementActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDepartementBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDepartementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Récupérer l'URL depuis l'intent
        val url = intent.getStringExtra("URL") ?: "https://www.gelgif.ulaval.ca/"

        // Configurer le WebView
        binding.webView.apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
            loadUrl(url)
        }

        // Bouton Fermer
        binding.buttonFermerDepartement.setOnClickListener {
            finish()
        }

        // Gérer le bouton retour
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.webView.canGoBack()) {
                    binding.webView.goBack()
                } else {
                    finish()
                }
            }
        })
    }
}
