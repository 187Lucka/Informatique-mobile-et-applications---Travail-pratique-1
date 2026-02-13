package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var profil: Profil

    // URLs à charger
    private val urlDepartement = "https://www.gelgif.ulaval.ca/"
    private val urlUniversiteLaval = "https://maps.google.com/?q=Université+Laval,+Quebec"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialiser l'objet Profil avec vos informations personnelles
        // IMPORTANT: Remplacez ces valeurs par vos vraies informations
        val dateNaissance = Calendar.getInstance().apply {
            set(2000, Calendar.JANUARY, 1) // Remplacez par votre vraie date
        }.time

        profil = Profil(
            nom = "Nom",           // Remplacez par votre nom
            prenom = "Prénom",     // Remplacez par votre prénom
            dateNaissance = dateNaissance,
            idul = "IDUL"          // Remplacez par votre IDUL
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
