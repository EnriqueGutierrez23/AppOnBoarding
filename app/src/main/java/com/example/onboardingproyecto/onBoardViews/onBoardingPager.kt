package com.example.onboardingproyecto.onBoardViews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onboardingproyecto.data.PageData
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import androidx.navigation.NavController
import com.example.onboardingproyecto.dataStore.StoreBoarding


@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingPager(
    item: List<PageData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    navController: NavController,
    store: StoreBoarding
) {
    Box(modifier = modifier.fillMaxHeight()) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,  
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(state = pagerState) { page ->
                Column(
                    modifier = Modifier
                        .padding(60.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Animación centrada
                    LoaderData(
                        modifier = Modifier
                            .size(200.dp)
                            .align(Alignment.CenterHorizontally),
                        image = item[page].imagen
                    )
                    // Título con menos padding superior
                    Text(
                        text = item[page].titulo,
                        modifier = Modifier.padding(top = 1.dp),
                        color = Color.Black,
                        style = MaterialTheme.typography.displayMedium,
                        fontWeight = FontWeight.Bold
                    )
                    // Descripción centrada
                    Text(
                        text = item[page].descripcion,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            }
            PagerIndicator(item.size, pagerState.currentPage)
        }


        Box(modifier = Modifier.align(Alignment.BottomCenter)) {

            ButtonFinish(pagerState.currentPage, navController, store)
        }
    }
}
