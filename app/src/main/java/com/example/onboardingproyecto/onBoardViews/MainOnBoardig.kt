package com.example.onboardingproyecto.onBoardViews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.onboardingproyecto.R
import com.example.onboardingproyecto.data.PageData
import com.example.onboardingproyecto.dataStore.StoreBoarding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainOnBoarding(navController: NavController, store: StoreBoarding) {
    val items = ArrayList<PageData>().apply {
        add(PageData(R.raw.page1, "Titulo 1", "Descripcion 1"))
        add(PageData(R.raw.page2, "Titulo 2", "Descripcion 2"))
        add(PageData(R.raw.page3, "Titulo 3", "Descripcion 3"))
    }
//
    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )

    OnBoardingPager(
        item = items,
        pagerState = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White),
        navController = navController,
        store = store
    )
}
