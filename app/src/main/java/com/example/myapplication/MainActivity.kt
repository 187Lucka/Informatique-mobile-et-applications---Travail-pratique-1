package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var profil: Profil

    private val urlDepartement = "https://www.gelgif.ulaval.ca/"
    private val urlUniversiteLaval = "https://maps.google.com/?q=Université+Laval,+Quebec"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dateNaissance = Calendar.getInstance().apply {
            set(2004, Calendar.OCTOBER, 19)
        }.time

        profil = Profil(
            nom = "Valtriani",
            prenom = "Lucka",
            dateNaissance = dateNaissance,
            idul = "luval50"
        )

        // Afficher le nom et prénom dans le TextView
        binding.textViewName.text = "${profil.prenom} ${profil.nom}"

        // Configurer les boutons
        binding.buttonUniversiteLaval.setOnClickListener {
            val intent = Intent(this, UniversiteLavalActivity::class.java)
            intent.putExtra("URL", urlUniversiteLaval)
            startActivity(intent)
        }

        binding.buttonDepartement.setOnClickListener {
            val intent = Intent(this, DepartementActivity::class.java)
            intent.putExtra("URL", urlDepartement)
            startActivity(intent)
        }

        binding.buttonMonProfil.setOnClickListener {
            val intent = Intent(this, MonProfilActivity::class.java)
            intent.putExtra("PROFIL", profil)
            startActivity(intent)
        }
    }
}
