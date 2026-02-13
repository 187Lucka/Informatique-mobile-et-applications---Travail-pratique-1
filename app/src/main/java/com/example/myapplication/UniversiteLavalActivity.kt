package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityUniversiteLavalBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class UniversiteLavalActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityUniversiteLavalBinding
    private lateinit var googleMap: GoogleMap

    // Coordonnées de l'Université Laval
    private val universiteLavalLatLng = LatLng(46.7797, -71.2753)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUniversiteLavalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialiser Google Maps
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // Bouton Fermer
        binding.buttonFermer.setOnClickListener {
            finish()
        }
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map

        // Ajouter un marqueur à l'Université Laval
        googleMap.addMarker(
            MarkerOptions()
                .position(universiteLavalLatLng)
                .title("Université Laval")
        )

        // Déplacer la caméra vers l'Université Laval
        googleMap.moveCamera(
            CameraUpdateFactory.newLatLngZoom(universiteLavalLatLng, 15f)
        )
    }
}
