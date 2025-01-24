package and.degilevich.dream.shared.compose.foundation.modifier.shimmer.controller

import and.degilevich.dream.shared.foundation.primitive.primitives.boolean.orFalse
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class ShimmerGradientAnimationControllerImpl(
    private val coroutineScope: CoroutineScope,
    private val animatableShimmerStart: Animatable<Float, AnimationVector1D>,
    private val animatableFlash: Animatable<Float, AnimationVector1D>,
    private val animatableShimmerEnd: Animatable<Float, AnimationVector1D>
) : ShimmerGradientAnimationController {

    private var infiniteAnimationJob: Job? = null

    override fun start() {
        stop()
        infiniteAnimationJob = coroutineScope.launch {
            while (infiniteAnimationJob?.isActive.orFalse()) {
                executeShimmerAnimationCycle()
            }
        }
    }

    override fun stop() {
        infiniteAnimationJob?.cancel()
        infiniteAnimationJob = null
    }

    private suspend fun executeShimmerAnimationCycle() {
        animateFlashAppear()
        animateFlashDisappear()
        delay(ANIMATION_RESTART_DURATION.toLong())
        resetAnimation()
    }

    private suspend fun animateFlashAppear() {
        with(coroutineScope) {
            launch {
                animatableShimmerEnd.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(
                        durationMillis = ANIMATION_PHASE_DURATION,
                        easing = LinearEasing
                    )
                )
            }
            launch {
                animatableFlash.animateTo(
                    targetValue = 0.5f,
                    animationSpec = tween(
                        durationMillis = ANIMATION_PHASE_DURATION,
                        easing = LinearEasing
                    )
                )
            }
            delay(ANIMATION_PHASE_DURATION.toLong())
        }
    }

    private suspend fun animateFlashDisappear() {
        with(coroutineScope) {
            launch {
                animatableFlash.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(
                        durationMillis = ANIMATION_PHASE_DURATION,
                        easing = LinearEasing
                    )
                )
            }
            launch {
                animatableShimmerStart.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(
                        durationMillis = ANIMATION_PHASE_DURATION,
                        easing = LinearEasing
                    )
                )
            }
            delay(ANIMATION_PHASE_DURATION.toLong())
        }
    }

    private suspend fun resetAnimation() {
        animatableShimmerStart.snapTo(targetValue = 0f)
        animatableFlash.snapTo(targetValue = 0f)
        animatableShimmerEnd.snapTo(targetValue = 0f)
    }

    private companion object {
        const val ANIMATION_PHASE_DURATION = 600 // 600 millis
        const val ANIMATION_RESTART_DURATION = 400 // 400 millis
    }
}