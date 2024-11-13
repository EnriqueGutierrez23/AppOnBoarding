package com.example.onboardingproyecto.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.onboardingproyecto.dataStore.StoreBoarding
import com.example.onboardingproyecto.onBoardViews.MainOnBoarding
import com.example.onboardingproyecto.views.HomeView

@Composable
fun NavManager() {
    val context = LocalContext.current
    val dataStore = StoreBoarding(context)
    val store = dataStore.getBoarding.collectAsState(initial = false)

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = if (store.value == true) "home" else "onBoarding")
    {
        composable("onBoarding") {
          MainOnBoarding(navController,dataStore)
        }
        composable("home") {
            HomeView(navController)
        }

    }
}