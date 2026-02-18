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
    private val urlUniversiteLaval = "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2733.606266!2d-71.2773173!3d46.7817499!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4cb896c469ff32f9%3A0x15feb853bd2f8247!2sUniversit%C3%A9%20Laval!5e0!3m2!1sfr!2sca!4v1639000000000!5m2!1sfr!2sca"

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
