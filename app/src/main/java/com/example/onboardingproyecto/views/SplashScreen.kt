package com.example.onboardingproyecto.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.onboardingproyecto.R
import kotlinx.coroutines.delay
@Composable
fun SplashScreen(navController: NavController, store: Boolean?) {
    var screen by remember { mutableStateOf("") }
    screen = if (store == true) "home" else "onBoarding"

    LaunchedEffect(key1 = true) {
        delay(5000) // Espera 3 segundos antes de navegar
        navController.navigate(screen) {
            popUpTo(0) { inclusive = true } // Asegura que no puedas volver al splash
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(painter = painterResource(id = R.drawable.cat), contentDescription = "Logo")
    }
}
