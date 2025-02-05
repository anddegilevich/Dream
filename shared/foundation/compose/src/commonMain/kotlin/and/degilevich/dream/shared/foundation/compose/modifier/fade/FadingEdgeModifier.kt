package and.degilevich.dream.shared.foundation.compose.modifier.fade

import and.degilevich.dream.shared.foundation.compose.ext.toPx
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

fun Modifier.fadingTop(fadeFraction: Float = DEFAULT_FADE_FRACTION): Modifier {
    return this.fadingEdge(
        Brush.verticalGradient(
            0f to Color.Transparent,
            fadeFraction to Color.White
        )
    )
}

fun Modifier.fadingTop(fadeHeight: Dp): Modifier {
    return this
        .composed {
            val density = LocalDensity.current
            var viewHeightPx by remember { mutableIntStateOf(0) }
            val fadeFraction = remember(fadeHeight, viewHeightPx, density) {
                fadeHeight.toPx(density) / viewHeightPx
            }

            this
                .onGloballyPositioned { layoutCoordinates ->
                    viewHeightPx = layoutCoordinates.size.height
                }
                .fadingTop(
                    fadeFraction = fadeFraction
                )
        }
}

fun Modifier.fadingBottom(fadeFraction: Float = DEFAULT_FADE_FRACTION): Modifier {
    return this.fadingEdge(
        Brush.verticalGradient(
            1f - fadeFraction to Color.White,
            1f to Color.Transparent
        )
    )
}

fun Modifier.fadingBottom(fadeHeight: Dp): Modifier {
    return this
        .composed {
            val density = LocalDensity.current
            var viewHeightPx by remember { mutableIntStateOf(0) }
            val fadeFraction = remember(fadeHeight, viewHeightPx, density) {
                fadeHeight.toPx(density) / viewHeightPx
            }

            this
                .onGloballyPositioned { layoutCoordinates ->
                    viewHeightPx = layoutCoordinates.size.height
                }
                .fadingBottom(
                    fadeFraction = fadeFraction
                )
        }
}

fun Modifier.fadingStart(fadeFraction: Float = DEFAULT_FADE_FRACTION): Modifier {
    return this.fadingEdge(
        Brush.horizontalGradient(
            0f to Color.Transparent,
            fadeFraction to Color.White,
        )
    )
}

fun Modifier.fadingStart(fadeWidth: Dp): Modifier {
    return this
        .composed {
            val density = LocalDensity.current
            var viewWidthPx by remember { mutableIntStateOf(0) }
            val fadeFraction = remember(fadeWidth, viewWidthPx, density) {
                fadeWidth.toPx(density) / viewWidthPx
            }

            this
                .onGloballyPositioned { layoutCoordinates ->
                    viewWidthPx = layoutCoordinates.size.width
                }
                .fadingStart(
                    fadeFraction = fadeFraction
                )
        }
}

fun Modifier.fadingEnd(fadeFraction: Float = DEFAULT_FADE_FRACTION): Modifier {
    return this.fadingEdge(
        Brush.horizontalGradient(
            1f - fadeFraction to Color.White,
            1f to Color.Transparent
        )
    )
}

fun Modifier.fadingEnd(fadeWidth: Dp): Modifier {
    return this
        .composed {
            val density = LocalDensity.current
            var viewWidthPx by remember { mutableIntStateOf(0) }
            val fadeFraction = remember(fadeWidth, viewWidthPx, density) {
                fadeWidth.toPx(density) / viewWidthPx
            }

            this
                .onGloballyPositioned { layoutCoordinates ->
                    viewWidthPx = layoutCoordinates.size.width
                }
                .fadingEnd(
                    fadeFraction = fadeFraction
                )
        }
}

private fun Modifier.fadingEdge(brush: Brush): Modifier {
    return this.graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
        .drawWithContent {
            drawContent()
            drawRect(
                brush = brush,
                blendMode = BlendMode.DstIn
            )
        }
}

private const val DEFAULT_FADE_FRACTION = 0.1f