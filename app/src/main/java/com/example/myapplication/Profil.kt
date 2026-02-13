package com.example.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class Profil(
    val nom: String,
    val prenom: String,
    val dateNaissance: Date,
    val idul: String
) : Parcelable
