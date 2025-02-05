package and.degilevich.dream.shared.foundation.compose.modifier.shimmer.controller

import and.degilevich.dream.shared.foundation.compose.modifier.shimmer.color.ShimmerColors
import androidx.compose.animation.core.Animatable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color

@Composable
internal fun rememberShimmerGradient(colors: ShimmerColors): Array<Pair<Float, Color>> {
    val animatableShimmerStart = remember { Animatable(initialValue = 0f) }
    val animatableFlash = remember { Animatable(initialValue = 0f) }
    val animatableShimmerEnd = remember { Animatable(initialValue = 0f) }
    val coroutineScope = rememberCoroutineScope()

    val shimmerGradientAnimationController: ShimmerGradientAnimationController = remember {
        ShimmerGradientAnimationControllerImpl(
            coroutineScope = coroutineScope,
            animatableShimmerStart = animatableShimmerStart,
            animatableFlash = animatableFlash,
            animatableShimmerEnd = animatableShimmerEnd
        )
    }

    DisposableEffect(Unit) {
        shimmerGradientAnimationController.start()
        onDispose {
            shimmerGradientAnimationController.stop()
        }
    }

    return arrayOf(
        animatableShimmerStart.value to colors.background,
        animatableFlash.value to colors.flash,
        animatableShimmerEnd.value to colors.background
    )
}