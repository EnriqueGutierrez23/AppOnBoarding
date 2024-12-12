package com.example.onboardingproyecto.views

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.onboardingproyecto.Paciente
import com.example.onboardingproyecto.PacienteDao
import kotlinx.coroutines.launch
@Composable
fun HomeView(navController: NavController, pacienteDao: PacienteDao) {
    var nombre by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var talla by remember { mutableStateOf("") }

    // Lista de pacientes
    val pacientes by produceState(initialValue = listOf<Paciente>()) {
        value = pacienteDao.obtenerTodosLosPacientes()  // Llamada a la función correcta
    }

    // Para lanzar las operaciones de base de datos
    val scope = rememberCoroutineScope()

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(text = "Registro de Pacientes", fontSize = 30.sp, fontWeight = FontWeight.Bold)

        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { /* Handle action */ }),
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        TextField(
            value = peso,
            onValueChange = { peso = it },
            label = { Text("Peso (kg)") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        TextField(
            value = talla,
            onValueChange = { talla = it },
            label = { Text("Talla (cm)") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Button(onClick = {
            if (nombre.isNotEmpty() && peso.isNotEmpty() && talla.isNotEmpty()) {
                // Inserta el nuevo paciente en la base de datos
                val paciente = Paciente(nombre = nombre, peso = peso.toInt(), talla = talla.toInt())
                scope.launch {
                    pacienteDao.insertarPaciente(paciente)
                }
                nombre = ""
                peso = ""
                talla = ""
            } else {
                Toast.makeText(navController.context, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text("Agregar Paciente")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Lista de Pacientes", fontSize = 20.sp)

        // Lista de pacientes
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(pacientes) { paciente ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = paciente.nombre)
                    Text(text = "Peso: ${paciente.peso} kg, Talla: ${paciente.talla} cm")
                    IconButton(onClick = {
                        scope.launch {
                            pacienteDao.eliminarPaciente(paciente.id)
                        }
                    }) {
                        Icon(Icons.Default.Delete, contentDescription = "Eliminar")
                    }
                }
            }
        }
    }
}
