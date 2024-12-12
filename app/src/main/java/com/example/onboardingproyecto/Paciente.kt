package com.example.onboardingproyecto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "paciente")
data class Paciente(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val peso: Int,
    val talla: Int
)
