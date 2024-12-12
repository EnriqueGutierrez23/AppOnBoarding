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
    Row(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        horizontalArrangement = if(currentPager !=2) Arrangement.SpaceBetween else Arrangement.Center
    ){
        if(currentPager == 2){
            OutlinedButton(onClick = {
                navController.navigate("home")
            }){
                Text(text = "Entrar", modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 40.dp)
                    , color = Color.Gray
                )
            }
        }
    }
}
