package com.example.onboardingproyecto


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class PacienteViewModel(private val pacienteDao: PacienteDao) : ViewModel() {
    private val _pacientes = mutableStateOf<List<Paciente>>(emptyList())
    val pacientes: State<List<Paciente>> = _pacientes

    init {
        obtenerPacientes()
    }

    private fun obtenerPacientes() {
        viewModelScope.launch {
            _pacientes.value = pacienteDao.obtenerTodosLosPacientes()
        }
    }

    fun insertarPaciente(paciente: Paciente) {
        viewModelScope.launch {
            pacienteDao.insertarPaciente(paciente)
            obtenerPacientes()
        }
    }

    fun eliminarPaciente(id: Int) {
        viewModelScope.launch {
            pacienteDao.eliminarPaciente(id)
            obtenerPacientes()
        }
    }
}