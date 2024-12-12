package com.example.onboardingproyecto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.NavigationRailItem
import androidx.navigation.compose.rememberNavController
import com.example.onboardingproyecto.dataStore.StoreBoarding
import com.example.onboardingproyecto.navigation.NavManager
import com.example.onboardingproyecto.onBoardViews.MainOnBoarding
import com.example.onboardingproyecto.ui.theme.OnBoardingProyectoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OnBoardingProyectoTheme {
                NavManager()
            }
        }
    }
}