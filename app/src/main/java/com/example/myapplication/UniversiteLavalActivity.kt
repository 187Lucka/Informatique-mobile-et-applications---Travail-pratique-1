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

        val url = intent.getStringExtra("URL") ?: "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2733.606266!2d-71.2773173!3d46.7817499!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4cb896c469ff32f9%3A0x15feb853bd2f8247!2sUniversit%C3%A9%20Laval!5e0!3m2!1sfr!2sca!4v1639000000000!5m2!1sfr!2sca"

        val htmlContent = """
            <!DOCTYPE html>
            <html>
            <head>
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <style>
                    body, html { margin: 0; padding: 0; height: 100%; overflow: hidden; }
                    iframe { border: 0; width: 100%; height: 100%; }
                </style>
            </head>
            <body>
                <iframe src="$url"
                    allowfullscreen="" loading="lazy"></iframe>
            </body>
            </html>
        """.trimIndent()

        binding.mapWebView.apply {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            webViewClient = WebViewClient()
            loadData(htmlContent, "text/html", "UTF-8")
        }

        binding.buttonFermer.setOnClickListener {
            finish()
        }
    }
}
