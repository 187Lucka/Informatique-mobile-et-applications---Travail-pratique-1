package com.example.myapplication

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMonProfilBinding
import java.text.SimpleDateFormat
import java.util.Locale

class MonProfilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMonProfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMonProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Récupérer l'objet Profil depuis l'intent
        val profil = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("PROFIL", Profil::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("PROFIL")
        }

        profil?.let {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.CANADA_FRENCH)

            binding.textViewPrenom.text = getString(R.string.prenom_label, it.prenom)
            binding.textViewNom.text = getString(R.string.nom_label, it.nom)
            binding.textViewDateNaissance.text = getString(R.string.date_naissance_label, dateFormat.format(it.dateNaissance))
            binding.textViewIdul.text = getString(R.string.idul_label, it.idul)
        }

        binding.buttonFermerProfil.setOnClickListener {
            finish()
        }
    }
}
