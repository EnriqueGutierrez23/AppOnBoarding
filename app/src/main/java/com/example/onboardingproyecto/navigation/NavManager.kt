package com.example.onboardingproyecto.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.onboardingproyecto.PacienteDatabase
import com.example.onboardingproyecto.dataStore.StoreBoarding
import com.example.onboardingproyecto.onBoardViews.MainOnBoarding
import com.example.onboardingproyecto.views.HomeView
import com.example.onboardingproyecto.views.SplashScreen

@Composable
fun NavManager() {
    val context = LocalContext.current
    val dataStore = StoreBoarding(context)
    val store = dataStore.getBoarding.collectAsState(initial = false)

    // Crear una instancia de la base de datos de Room y acceder al PacienteDao
    val db = PacienteDatabase.getDatabase(context)
    val pacienteDao = db.pacienteDao()

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = if (store.value) "home" else "splash") {
        composable("onBoarding") {
            MainOnBoarding(navController, dataStore)
        }
        composable("home") {
            // Aquí le pasamos el pacienteDao a HomeView
            HomeView(navController, pacienteDao)
        }
        composable("splash") {
            SplashScreen(navController, store.value)
        }
    }
}
