package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityUniversiteLavalBinding

class UniversiteLavalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUniversiteLavalBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUniversiteLavalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // URL de Google Maps pour l'Université Laval
        val mapUrl = "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2733.6166!2d-71.2753!3d46.7797!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4cb896b8f0c8e8e1%3A0x5f3a0e8e8e8e8e8!2sUniversit%C3%A9%20Laval!5e0!3m2!1sen!2sca!4v1234567890"

        // Configurer le WebView
        binding.mapWebView.apply {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            webViewClient = WebViewClient()
            loadUrl(mapUrl)
        }

        // Bouton Fermer
        binding.buttonFermer.setOnClickListener {
            finish()
        }
    }
}
