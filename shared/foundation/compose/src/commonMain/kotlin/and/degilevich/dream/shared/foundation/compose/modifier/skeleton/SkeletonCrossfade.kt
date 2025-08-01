package and.degilevich.dream.shared.foundation.compose.modifier.skeleton

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun <T> SkeletonCrossfade(
    skeleton: Skeleton<T>,
    loadingContent: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    animationSpec: FiniteAnimationSpec<Float> = tween(),
    content: @Composable (T) -> Unit
) {
    Crossfade(
        modifier = modifier,
        animationSpec = animationSpec,
        targetState = skeleton
    ) { skeleton ->
        when (skeleton) {
            is Skeleton.Loading -> loadingContent()
            is Skeleton.Value<T> -> content(skeleton.value)
        }
    }
}