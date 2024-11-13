package com.example.onboardingproyecto.onBoardViews

import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.onboardingproyecto.dataStore.StoreBoarding


@Composable
fun ButtonFinish(currentPager: Int, navController: NavController, store: StoreBoarding) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        if (currentPager != 2) {
            Row(
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(y = 100.dp)
            ) {
                OutlinedButton(
                    onClick = {
                        navController.navigate("home") {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.padding(horizontal = 40.dp)
                ) {
                    Text(
                        text = "Entrar",
                        modifier = Modifier.padding(vertical = 8.dp),
                        color = Color.Gray
                    )
                }
            }
        }
    }
}
