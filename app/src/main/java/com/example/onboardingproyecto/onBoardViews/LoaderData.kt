package com.example.onboardingproyecto.onBoardViews

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.airbnb.lottie.compose.LottieConstants

@Composable
fun LoaderData(modifier: Modifier = Modifier, image: Int) {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(image))


    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = Modifier
    )
}
