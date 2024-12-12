package com.example.onboardingproyecto

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PacienteDao {


    @Insert
    suspend fun insertarPaciente(paciente: Paciente)


    @Query("SELECT * FROM paciente")
    suspend fun obtenerTodosLosPacientes(): List<Paciente>


    @Query("DELETE FROM paciente WHERE id = :id")
    suspend fun eliminarPaciente(id: Int)
}
